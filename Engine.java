package com;

import com.sun.speech.freetts.*;
import org.hibernate.Query;
import org.hibernate.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA.
 * User: sammi
 * Date: 11/28/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Engine
{

    public static void main(String[] args)
    {

        final UI ui = new UI();
        ui.enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                  int chapter = Integer.parseInt(e.getActionCommand());
                  query(chapter,ui);
            }
        });

    }

    public static void query(int x,UI passedUI)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM JohnEntity WHERE chapter = :enteredChapter");
        query.setParameter("enteredChapter",x);

        List verses = query.list();

        JohnEntity tableObject = (JohnEntity) verses.get(0);



        if(tableObject.getText()==null)
        {
            JOptionPane.showMessageDialog(null,"There was no matching chapter for your query");
        }
       else
        {
            String tts =  tableObject.getText();

            passedUI.content.setText(tableObject.getText());

            Voice voice = null;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice("kevin16");
            voice.allocate();
            voice.speak(tts);
        }

    }


}
