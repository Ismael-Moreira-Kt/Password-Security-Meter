package com.example.backend.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class SenhaUtil {
    public static String calculaComplexidade(String senha) {

        int nScore = 0, nLength = 0, nAlphaUC = 0, nAlphaLC = 0, nNumber = 0, nSymbol = 0, nMidChar = 0, nRequirements = 0,
                nAlphasOnly = 0, nNumbersOnly = 0, nUnqChar = 0, nRepChar = 0, nRepInc = 0, nConsecAlphaUC = 0,
                nConsecAlphaLC = 0, nConsecNumber = 0, nConsecSymbol = 0, nConsecCharType = 0, nSeqAlpha = 0,
                nSeqNumber = 0, nSeqSymbol = 0, nSeqChar = 0, nReqChar = 0, nMultConsecCharType = 0;
        int nMultRepChar = 1, nMultConsecSymbol = 1;
        int nMultMidChar = 2, nMultRequirements = 2, nMultConsecAlphaUC = 2, nMultConsecAlphaLC = 2, nMultConsecNumber = 2;
        int nReqCharType = 3, nMultAlphaUC = 3, nMultAlphaLC = 3, nMultSeqAlpha = 3, nMultSeqNumber = 3, nMultSeqSymbol = 3;
        int nMultLength = 4, nMultNumber = 4;
        int nMultSymbol = 6;

        String nTmpAlphaUC = "", nTmpAlphaLC = "", nTmpNumber = "", nTmpSymbol = "";
        String sAlphaUC = "0", sAlphaLC = "0", sNumber = "0", sSymbol = "0", sMidChar = "0", sRequirements = "0",
                sAlphasOnly = "0", sNumbersOnly = "0", sRepChar = "0", sConsecAlphaUC = "0", sConsecAlphaLC = "0",
                sConsecNumber = "0", sSeqAlpha = "0", sSeqNumber = "0", sSeqSymbol = "0";
        String sAlphas = "abcdefghijklmnopqrstuvwxyz";
        String sNumerics = "01234567890";
        String sSymbols = ")!@#$%^&*()";
        String sComplexity = "Too Short";
        String sStandards = "Below";

        int nMinPwdLen = 8;

        if (senha != null && !senha.isEmpty()) {
            nScore = senha.length() * nMultLength;
            nLength = senha.length();
            String[] arrPwd = senha.replaceAll("\\s+", "").split("");
            int arrPwdLen = arrPwd.length;

            for (int a = 0; a < arrPwdLen; a++) {
                if (arrPwd[a].matches("[A-Z]")) {
                    if (!nTmpAlphaUC.isEmpty() && Integer.parseInt(nTmpAlphaUC) + 1 == a) {
                        nConsecAlphaUC++;
                        nConsecCharType++;
                    }
                    nTmpAlphaUC = Integer.toString(a);
                    nAlphaUC++;
                } else if (arrPwd[a].matches("[a-z]")) {
                    if (!nTmpAlphaLC.isEmpty() && Integer.parseInt(nTmpAlphaLC) + 1 == a) {
                        nConsecAlphaLC++;
                        nConsecCharType++;
                    }
                    nTmpAlphaLC = Integer.toString(a);
                    nAlphaLC++;
                } else if (arrPwd[a].matches("[0-9]")) {
                    if (a > 0 && a < (arrPwdLen - 1)) {
                        nMidChar++;
                    }
                    if (!nTmpNumber.isEmpty() && Integer.parseInt(nTmpNumber) + 1 == a) {
                        nConsecNumber++;
                        nConsecCharType++;
                    }
                    nTmpNumber = Integer.toString(a);
                    nNumber++;
                } else if (arrPwd[a].matches("[^a-zA-Z0-9_]")) {
                    if (a > 0 && a < (arrPwdLen - 1)) {
                        nMidChar++;
                    }
                    if (!nTmpSymbol.isEmpty() && Integer.parseInt(nTmpSymbol) + 1 == a) {
                        nConsecSymbol++;
                        nConsecCharType++;
                    }
                    nTmpSymbol = Integer.toString(a);
                    nSymbol++;
                }

                boolean bCharExists = false;
                for (int b = 0; b < arrPwdLen; b++) {
                    if (arrPwd[a].equals(arrPwd[b]) && a != b) {
                        bCharExists = true;
                        nRepInc += Math.abs(arrPwdLen / (b - a));
                    }
                }
                if (bCharExists) {
                    nRepChar++;
                    nUnqChar = arrPwdLen - nRepChar;
                    nRepInc = (nUnqChar != 0) ? (int) Math.ceil(nRepInc / nUnqChar) : (int) Math.ceil(nRepInc);
                }
            }

            for (int s = 0; s < 23; s++) {
                String sFwd = sAlphas.substring(s, s + 3);
                String sRev = new StringBuilder(sFwd).reverse().toString();
                if (senha.toLowerCase().indexOf(sFwd) != -1 || senha.toLowerCase().indexOf(sRev) != -1) {
                    nSeqAlpha++;
                    nSeqChar++;
                }
            }

            for (int s = 0; s < 8; s++) {
                String sFwd = sNumerics.substring(s, s + 3);
                String sRev = new StringBuilder(sFwd).reverse().toString();
                if (senha.toLowerCase().indexOf(sFwd) != -1 || senha.toLowerCase().indexOf(sRev) != -1) {
                    nSeqNumber++;
                    nSeqChar++;
                }
            }

            for (int s = 0; s < 8; s++) {
                String sFwd = sSymbols.substring(s, s + 3);
                String sRev = new StringBuilder(sFwd).reverse().toString();
                if (senha.toLowerCase().indexOf(sFwd) != -1 || senha.toLowerCase().indexOf(sRev) != -1) {
                    nSeqSymbol++;
                    nSeqChar++;
                }
            }

            if (nAlphaUC > 0 && nAlphaUC < nLength) {
                nScore += (nLength - nAlphaUC) * 2;
                sAlphaUC = "+ " + (nLength - nAlphaUC) * 2;
            }
            if (nAlphaLC > 0 && nAlphaLC < nLength) {
                nScore += (nLength - nAlphaLC) * 2;
                sAlphaLC = "+ " + (nLength - nAlphaLC) * 2;
            }
            if (nNumber > 0 && nNumber < nLength) {
                nScore += nNumber * nMultNumber;
                sNumber = "+ " + nNumber * nMultNumber;
            }
            if (nSymbol > 0) {
                nScore += nSymbol * nMultSymbol;
                sSymbol = "+ " + nSymbol * nMultSymbol;
            }
            if (nMidChar > 0) {
                nScore += nMidChar * nMultMidChar;
                sMidChar = "+ " + nMidChar * nMultMidChar;
            }

            if ((nAlphaLC > 0 || nAlphaUC > 0) && nSymbol == 0 && nNumber == 0) {
                nScore -= nLength;
                nAlphasOnly = nLength;
                sAlphasOnly = "- " + nLength;
            }
            if (nAlphaLC == 0 && nAlphaUC == 0 && nSymbol == 0 && nNumber > 0) {
                nScore -= nLength;
                nNumbersOnly = nLength;
                sNumbersOnly = "- " + nLength;
            }
            if (nRepChar > 0) {
                nScore -= nRepInc;
                sRepChar = "- " + nRepInc;
            }
            if (nConsecAlphaUC > 0) {
                nScore -= nConsecAlphaUC * nMultConsecAlphaUC;
                sConsecAlphaUC = "- " + nConsecAlphaUC * nMultConsecAlphaUC;
            }
            if (nConsecAlphaLC > 0) {
                nScore -= nConsecAlphaLC * nMultConsecAlphaLC;
                sConsecAlphaLC = "- " + nConsecAlphaLC * nMultConsecAlphaLC;
            }
            if (nConsecNumber > 0) {
                nScore -= nConsecNumber * nMultConsecNumber;
                sConsecNumber = "- " + nConsecNumber * nMultConsecNumber;
            }
            if (nSeqAlpha > 0) {
                nScore -= nSeqAlpha * nMultSeqAlpha;
                sSeqAlpha = "- " + nSeqAlpha * nMultSeqAlpha;
            }
            if (nSeqNumber > 0) {
                nScore -= nSeqNumber * nMultSeqNumber;
                sSeqNumber = "- " + nSeqNumber * nMultSeqNumber;
            }
            if (nSeqSymbol > 0) {
                nScore -= nSeqSymbol * nMultSeqSymbol;
                sSeqSymbol = "- " + nSeqSymbol * nMultSeqSymbol;
            }

            int[] arrChars = {nLength, nAlphaUC, nAlphaLC, nNumber, nSymbol};
            String[] arrCharsIds = {"nLength", "nAlphaUC", "nAlphaLC", "nNumber", "nSymbol"};
            int arrCharsLen = arrChars.length;
            for (int c = 0; c < arrCharsLen; c++) {
                String oImg = "div_" + arrCharsIds[c];
                String oBonus = arrCharsIds[c] + "Bonus";
                arrCharsIds[c] = Integer.toString(arrChars[c]);
                int minVal = (arrCharsIds[c].equals("nLength")) ? nMinPwdLen - 1 : 0;
                if (arrChars[c] == (minVal + 1)) {
                    nReqChar++;
                    oImg = "pass";
                    oBonus = "pass";
                } else if (arrChars[c] > (minVal + 1)) {
                    nReqChar++;
                    oImg = "exceed";
                    oBonus = "exceed";
                } else {
                    oImg = "fail";
                    oBonus = "fail";
                }
            }
            nRequirements = nReqChar;
            int nMinReqChars = (senha.length() >= nMinPwdLen) ? 3 : 4;
            if (nRequirements > nMinReqChars) {
                nScore += nRequirements * 2;
                sRequirements = "+ " + nRequirements * 2;
            }

            int[] arrCharsBonus = {nMidChar, nRequirements};
            String[] arrCharsIdsBonus = {"nMidChar", "nRequirements"};
            int arrCharsLenBonus = arrCharsBonus.length;
            for (int c = 0; c < arrCharsLenBonus; c++) {
                String oImg = "div_" + arrCharsIdsBonus[c];
                String oBonus = arrCharsIdsBonus[c] + "Bonus";
                arrCharsIdsBonus[c] = Integer.toString(arrCharsBonus[c]);
                int minVal = (arrCharsIdsBonus[c].equals("nRequirements")) ? nMinReqChars : 0;
                if (arrCharsBonus[c] == (minVal + 1)) {
                    oImg = "pass";
                    oBonus = "pass";
                } else if (arrCharsBonus[c] > (minVal + 1)) {
                    oImg = "exceed";
                    oBonus = "exceed";
                } else {
                    oImg = "fail";
                    oBonus = "fail";
                }
            }

            int[] arrCharsSuggested = {nAlphasOnly, nNumbersOnly, nRepChar, nConsecAlphaUC, nConsecAlphaLC, nConsecNumber,
                    nSeqAlpha, nSeqNumber, nSeqSymbol};
            String[] arrCharsIdsSuggested = {"nAlphasOnly", "nNumbersOnly", "nRepChar", "nConsecAlphaUC",
                    "nConsecAlphaLC", "nConsecNumber", "nSeqAlpha", "nSeqNumber", "nSeqSymbol"};
            int arrCharsLenSuggested = arrCharsSuggested.length;
            for (int c = 0; c < arrCharsLenSuggested; c++) {
                String oImg = "div_" + arrCharsIdsSuggested[c];
                String oBonus = arrCharsIdsSuggested[c] + "Bonus";
                arrCharsIdsSuggested[c] = Integer.toString(arrCharsSuggested[c]);
                if (arrCharsSuggested[c] > 0) {
                    oImg = "warn";
                    oBonus = "warn";
                } else {
                    oImg = "pass";
                    oBonus = "pass";
                }
            }

            if (nScore > 100) {
                nScore = 100;
            } else if (nScore < 0) {
                nScore = 0;
            }
            if (nScore >= 0 && nScore < 20) {
                sComplexity = "Very Weak";
            } else if (nScore >= 20 && nScore < 40) {
                sComplexity = "Weak";
            } else if (nScore >= 40 && nScore < 60) {
                sComplexity = "Good";
            } else if (nScore >= 60 && nScore < 80) {
                sComplexity = "Strong";
            } else if (nScore >= 80 && nScore <= 100) {
                sComplexity = "Very Strong";
            }
        }

        return sComplexity;
    }



    public static String criptografarSenha(String senha) throws Exception {
        byte[] secretKeyBytes = Arrays.copyOf(senha.getBytes(StandardCharsets.UTF_8), 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedBytes = cipher.doFinal(senha.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
