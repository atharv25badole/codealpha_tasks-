import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCountApp {
    public static void main(String[] args) {
        // Create the frame for the application
        JFrame frame = new JFrame("Word Count Application");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set a layout manager (BorderLayout for flexible resizing)
        frame.setLayout(new BorderLayout());

        // Create a text area for entering the paragraph (10 rows, 40 columns)
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);  // Enable line wrapping
        textArea.setWrapStyleWord(true);  // Wrap at word boundaries
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));  // Set font style

        // Create a scroll pane for the text area and make it resizable
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Add the scrollable text area to the center of the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create panels for layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Add color and font styles to buttons
        JButton countButton = new JButton("Count Words");
        countButton.setBackground(new Color(30, 144, 255));  // Blue background
        countButton.setForeground(Color.WHITE);  // White text
        countButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(255, 69, 0));  // Red background
        resetButton.setForeground(Color.WHITE);  // White text
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Create labels to display the word count, character count, sentence count, and paragraph count
        JLabel wordCountLabel = new JLabel("Words: 0");
        JLabel charCountLabel = new JLabel("Characters (with spaces): 0");
        JLabel sentenceCountLabel = new JLabel("Sentences: 0");
        JLabel paragraphCountLabel = new JLabel("Paragraphs: 0");

        wordCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        charCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        sentenceCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        paragraphCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add components to the panel
        panel.add(countButton);
        panel.add(resetButton);
        panel.add(wordCountLabel);
        panel.add(charCountLabel);
        panel.add(sentenceCountLabel);
        panel.add(paragraphCountLabel);

        // Add panel to the frame (bottom section)
        frame.add(panel, BorderLayout.SOUTH);

        // Button action to count the words, characters, sentences, and paragraphs in the text area
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                int charCountWithSpaces = countCharacters(text);
                int sentenceCount = countSentences(text);
                int paragraphCount = countParagraphs(text);

                wordCountLabel.setText("Words: " + wordCount);
                charCountLabel.setText("Characters (with spaces): " + charCountWithSpaces);
                sentenceCountLabel.setText("Sentences: " + sentenceCount);
                paragraphCountLabel.setText("Paragraphs: " + paragraphCount);
            }
        });

        // Button action to reset the text area and all counts
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");  // Clear the text area
                wordCountLabel.setText("Words: 0");
                charCountLabel.setText("Characters (with spaces): 0");
                sentenceCountLabel.setText("Sentences: 0");
                paragraphCountLabel.setText("Paragraphs: 0");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to count words in a given text
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Method to count characters (including spaces) in a given text
    public static int countCharacters(String text) {
        return text.length();
    }

    // Method to count sentences based on punctuation marks (periods, exclamations, question marks)
    public static int countSentences(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    // Method to count paragraphs based on empty lines
    public static int countParagraphs(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] paragraphs = text.split("\\n\\s*\\n");
        return paragraphs.length;
    }
}
