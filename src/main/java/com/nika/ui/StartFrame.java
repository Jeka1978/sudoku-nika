package com.nika.ui;

import com.nika.GameManager;

import javax.swing.*;
import java.awt.*;

import static com.nika.GameLevel.*;

/**
 * @author Evgeny Borisov
 */
public class StartFrame extends JFrame {

    private GameManager gameManager = new GameManager();

    public StartFrame() throws HeadlessException {
        JButton easyBtn = new JButton("EASY");
        easyBtn.addActionListener(e -> gameManager.createGame(EASY));

        JButton mediumBtn = new JButton("MEDIUM");
        mediumBtn.addActionListener(e -> gameManager.createGame(MEDIUM));


        JButton hardBtn = new JButton("HARD");
        easyBtn.addActionListener(e -> gameManager.createGame(HARD));


        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4,1));
        contentPane.add(new JLabel("choose level"));
        contentPane.add(easyBtn);
        contentPane.add(mediumBtn);
        contentPane.add(hardBtn);


        setContentPane(contentPane);

        setSize(600,600);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }
}
