package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: sammi
 * Date: 11/28/13
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class UI extends JFrame
{
    JLabel title;
    JLabel intro;
    JLabel intro1;
    JLabel intro2;
    JLabel intro3;
    JLabel enterHere;
    JButton speak;
    JPanel panel;
    TextField enter;
    TextArea content;
    ImageIcon speakButton;
    JScrollPane scroll;


    UI()
    {
        super("BibleTTS");
        panel = new JPanel();

        title = new JLabel("BibleTTS");
        panel.add(title);

        enterHere = new JLabel("Enter Chapter here");
        panel.add(enterHere);

        enter =  new TextField(20);
        panel.add(enter);

        content = new TextArea();
        content.setEditable(false);
        scroll = new JScrollPane(content);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scroll);

        add(panel);

        setSize(800,300);
        setVisible(true);


    }
}
