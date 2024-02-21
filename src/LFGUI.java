import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LFGUI implements KeyListener{
private JButton go;
private JTextField website;
private JTextField keyword;
private JPanel panel;
private JFrame frame;

    public LFGUI() {
        go = new JButton("Go!");
        go.setSize(5,5);
        website = new JTextField("Enter Website URL");
        website.setColumns(32);
        keyword = new JTextField("Enter Search Term");
        keyword.setColumns(25);
        panel = new JPanel();
        frame = new JFrame("Link Finder");

        panel.setLayout(new FlowLayout());
        panel.add(website);
        panel.add(keyword, FlowLayout.CENTER);
        panel.add(go);
        frame.add(panel);
        frame.setSize(400,150);
        frame.setVisible(true);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tempFrame = new JFrame();
                JPanel tempPanel = new JPanel();
                JTextArea links = new JTextArea();
                JScrollPane tempScrollPane = new JScrollPane();


                LinkFind linkFind = new LinkFind(website.getText(), keyword.getText());
                links.setText(linkFind.finalString);
                links.setEditable(false);
                tempScrollPane.setViewportView(links);
                tempPanel.setLayout(new BorderLayout());
                tempPanel.add(tempScrollPane, BorderLayout.CENTER);
                tempFrame.add(tempPanel);
                tempFrame.setSize(500,350);
                tempFrame.setVisible(true);

                website.setText("Enter Website URL");
                keyword.setText("Enter Search Term");

            }
        });

    }


    @Override
    public void keyTyped(KeyEvent e) {
       int code = e.getKeyCode();
        System.out.println(code);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println(code);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
