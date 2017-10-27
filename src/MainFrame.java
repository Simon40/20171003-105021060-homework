import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    public MainFrame(){
        initComp();
    }
    private Container cp;
    private JButton jb1=new JButton("Example");
    private JButton jb2=new JButton("Encrypt");
    private JButton jb3=new JButton("Clear");
    private JButton jb4=new JButton("Exit");
    private JLabel jla=new JLabel("Key");
    private JTextArea jtal=new JTextArea();
    private JTextArea jtar=new JTextArea();
    private JTextField jfKey=new JTextField("0");
    private JScrollPane jspl=new JScrollPane();
    private JScrollPane jspr=new JScrollPane();
    private JPanel jpl=new JPanel(new GridLayout(6,1,3,3));
    private int x=0;
    public void initComp(){
        this.setBounds(100,100,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(jpl,BorderLayout.CENTER);
        this.add(jtal,BorderLayout.WEST);
        this.add(jtar,BorderLayout.EAST);
        //cp=this.getContentPane();
        //cp.setLayout(new BorderLayout(3,3));
        jtal.setPreferredSize(new Dimension(200,400));
        jtal.setLineWrap(true);
        jtar.setPreferredSize(new Dimension(200,400));
        jtar.setLineWrap(true);
        jla.setHorizontalAlignment(JLabel.CENTER);
        jpl.add(jb1);
        jpl.add(jb2);
        jpl.add(jla);
        jpl.add(jfKey);
        jpl.add(jb3);
        jpl.add(jb4);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtal.setText("In the 2017 RedDot Award report," +
                        " 13 artworks from 33 students of the Visual Communication Design (VCD) Dept." +
                        " and the Digital Media Design (DMD) Dept. of Asia University (AU) have entered the winner list." +
                        " Two of them, “Neiwan Love Story” and“Taiwan Old-street " +
                        "Chinese Characters” win the “Best of the Best” " +
                        "Awards, and the designers of the artworks will attend the " +
                        "RedDot Awarding Ceremony in October.");
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[]=jtal.getText().toCharArray();
                int len=data.length;
                for(int i=0;i<len;i++){
                    data[i]+=Integer.parseInt(jfKey.getText());
                }
                jtar.setText(new String(data));
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtal.setText("");
                jtar.setText("");
                jfKey.setText("0");
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}