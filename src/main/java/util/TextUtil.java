package util;

import java.util.List;

public class TextUtil {

    public static boolean isValidTextList(List<String> textList) {
        if (textList == null) {
            return false;  // Se a lista for nula, não é válida
        }

        for (String string : textList) {
            if (!isValidText(string)) {
                return false;  // Se encontrar uma string inválida, retorna false
            }
        }
        return true;  // Se todas as strings forem válidas, retorna true
    }

    public static boolean isValidText(String text) {
        return text != null && !text.isEmpty();  // Retorna true se a string não for nula e não for vazia
    }
}
