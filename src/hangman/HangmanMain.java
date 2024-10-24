package hangman;

public class Hangman {

    public static void main(String[] args) {

        HangmanDisplay display = new HangmanDisplay(); //инициализация классов, работающих с 1) выводом; 2) словами; 3) информацией о попытках и тек. слове
        HangmanWords words = new HangmanWords();
        HangmanInfo info = new HangmanInfo();

        info.setWord(words.getWord()); //задаётся слово для разгадывания
        info.attempts = 6; //задаётся начальное количество попыток

        while (info.attempts != 0 && !info.isGuessed(info.word, info.currentWord)) {
            display.printHangman(info.attempts); //вывод виселицы
            display.showCurrentStateOfWord(info.currentWord); //вывод состояния слова, которое нужно отгадать
            display.showCurrentStateOfAttempts(info.attempts); //вывод количества жизней
            info.inputChar = display.getChar(); //ввод игроком буквы
            if (!info.checkCharInWord(info.inputChar)) {
                info.attempts--; //если догадка неправильная, уменьшается количество жизней
            }
        }
        if (info.attempts == 0) {
            display.printHangman(info.attempts); //вывод финального проигрышного человечка
            display.showCurrentStateOfAttempts(info.attempts);
        }
        display.showResult(info.isGuessed(info.word, info.currentWord)); //вывод поздравления или сочувствия, в зависимости от результата
    }
}
