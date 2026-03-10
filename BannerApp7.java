public class BannerApp7 {

    static class CharacterPatternMap {
        private final char character;
        private String[] pattern;

        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] maps = new CharacterPatternMap[4];

        maps[0] = new CharacterPatternMap('O', new String[]{
                "   ***   ",
                " **   ** ",
                "**     **",
                "**     **",
                "**     **",
                "**     **",
                "**     **",
                " **   ** ",
                "   ***   "
        });

        maps[1] = new CharacterPatternMap('P', new String[]{
                "*****    ",
                "**   **  ",
                "**    ** ",
                "**   **  ",
                "*****    ",
                "**       ",
                "**       ",
                "**       ",
                "**       "
        });

        maps[2] = new CharacterPatternMap('S', new String[]{
                " *****   ",
                "**       ",
                "**       ",
                " **      ",
                "   ***   ",
                "      ** ",
                "       **",
                "      ** ",
                " *****   "
        });

        maps[3] = new CharacterPatternMap(' ', new String[]{
                "         ",
                "         ",
                "         ",
                "         ",
                "         ",
                "         ",
                "         ",
                "         ",
                "         "
        });

        return maps;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', charMaps);
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        // Dynamically determine height from the first character’s pattern
        int height = charMaps[0].getPattern().length;

        for (int line = 0; line < height; line++) {
            for (int i = 0; i < message.length(); i++) {
                String[] pattern = getCharacterPattern(
                        Character.toUpperCase(message.charAt(i)), charMaps);
                System.out.print(pattern[line] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}