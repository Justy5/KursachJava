
import javax.swing.*;
import java.awt.*;


public class Start {
    public static int wwidth;
    public static int wheight;
    TransparentJPanel one, two, three, four, five, six;
    JFrame f;
    JPanel panel1;
    JTabbedPane tabbedPane1;
    TransparentJPanel Main, Tasks, Client, Orders, Sales, Logs;
    FirstTab firstTab;
    SecondTab secondTab;
    ClientTab clientTab;
    SalesTab salesTab;
    OrdersTab ordersTab;
    LogsTab logsTab;
    JScrollPane scrollPane;

    Start() throws Exception{


        f = new JFrame();
        f.pack();
        f.setTitle("Hotel Application");
        panel1 = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                Image img = Toolkit.getDefaultToolkit().getImage("main_background.png");
                g.drawImage(img, 0,0,this);
            }
        };

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(-5,0);
        wwidth = screenSize.width+20;
        wheight = screenSize.height - Toolkit.getDefaultToolkit().getScreenInsets(new Frame().getGraphicsConfiguration()).bottom;

        f.setSize(new Dimension(wwidth, wheight));
     /*   f.setResizable(false);
      */
        UIManager.put("TabbedPane.background", new Color(0,0,0,0));
        UIManager.put("TabbedPane.selected", new Color(180,208,255));
        UIManager.put("TabbedPane.tabsOpaque", Boolean.TRUE);
        UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
        tabbedPane1 = new JTabbedPane();

        SwingUtilities.updateComponentTreeUI(tabbedPane1);
        tabbedPane1.setTabPlacement(2);
        tabbedPane1.setPreferredSize(new Dimension(wwidth, wheight));


        Main = new TransparentJPanel();
        Main.setPreferredSize(new Dimension(wwidth / 5 * 4, wheight));
        firstTab = new FirstTab();
        one = new TransparentJPanel();
        one = firstTab.createOne(one);

        Tasks = new TransparentJPanel();
        Tasks.setPreferredSize(new Dimension(wwidth / 5 * 4, wheight));
        secondTab = new SecondTab();
        two = new TransparentJPanel(new Color(180, 208, 255));
        two = secondTab.createOne(two);

        Client = new TransparentJPanel(new Color(180,216,219));
        Client.setPreferredSize(new Dimension(wwidth / 5 * 4, wheight));
        clientTab = new ClientTab(tabbedPane1);
        three = new TransparentJPanel(new Color(180,216,219));
        three = clientTab.create(three);

        Orders = new TransparentJPanel();
        Orders.setPreferredSize(new Dimension(wwidth / 5 * 4, wheight));
        ordersTab = new OrdersTab();
        four = new TransparentJPanel(new Color(180,216,219));
        four = ordersTab.create(four);

        Sales = new TransparentJPanel();
        Sales.setPreferredSize(new Dimension(wwidth / 5 * 4, wheight));
        salesTab = new SalesTab();
        five = new TransparentJPanel();
        five = salesTab.create(five);

        Logs = new TransparentJPanel();
        Logs.setPreferredSize(new Dimension(wwidth / 5 * 4, wheight));
        logsTab = new LogsTab();
        six = new TransparentJPanel();
        six = logsTab.create(six);

        one.setPreferredSize(new Dimension(wwidth / 8 * 7, wheight));
        two.setPreferredSize(new Dimension(wwidth / 8 * 7, wheight));

        UIManager.put("ScrollPane.background", new Color(0, 0, 0, 0));
        UIManager.put("ScrollPane.contentOpaque", false);

        scrollPane = new JScrollPane(one, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        Main.setLayout(new BoxLayout(Main, BoxLayout.PAGE_AXIS));

        System.out.println(scrollPane.getPreferredSize().width + " " + scrollPane.getPreferredSize().height);
        System.out.println(scrollPane.getSize().width + " " + scrollPane.getSize().height);

        Main.add(one);
        Tasks.add(two);
        Client.add(three);
        Orders.add(four);
        Sales.add(five);
        Logs.add(six);
        tabbedPane1.addTab("Головна", Main);
        tabbedPane1.addTab("Задачі", Tasks);
        tabbedPane1.addTab("Клієнти", Client);
        tabbedPane1.addTab("Замовлення", Orders);
        tabbedPane1.addTab("Послуги", Sales);
        tabbedPane1.addTab("Логи", Logs);
/*First Tab*/
/*tabs size*/
        int height = (f.getSize().height) / 10;
        for (int i = 0; i < 6; i++) {
            String name = tabbedPane1.getTitleAt(i);
            tabbedPane1.setTitleAt(i, "<html><div style='padding-left: " + (height / 6) + "px;padding-right: " + (height / 6) + "px; padding-top: " + (height / 6) * 2 + "px; padding-bottom: " + (height / 6) * 2 + "px'><h1>" + name + "</h1></div></html>");
        }
        tabbedPane1.setEnabledAt(1, true);
        panel1.add(tabbedPane1);
        f.add(panel1);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Thread a = new Thread(() -> {
            try {
                while (true) {
                    one = firstTab.updateOne(one);
                    one.repaint();
                    panel1.repaint();
                    Thread.sleep(2500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        a.start();
    }
}

class TransparentJPanel extends JPanel
{
    TransparentJPanel(){
        super();
        this.setBackground(new Color(0,0,0,0));
    }

    TransparentJPanel(Color color){
        super();
        this.setBackground(color);
    }
}