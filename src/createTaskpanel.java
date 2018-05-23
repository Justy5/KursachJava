
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

class TaskPanel extends  TransparentJPanel{

    JLabel DroppedTaskName;
    JLabel DroppedTaskCount;
    JLabel DroppedTaskProcent;
    JLabel newTaskName;
    JLabel newTaskCount;
    JLabel newTaskProcent;
    JLabel TaskInProcessName;
    JLabel TaskInProcessCount;
    JLabel TaskInProcessProcent;
    JLabel SuccessTaskName;
    JLabel SuccessTaskCount;
    JLabel SuccessTaskProc;

    TransparentJPanel create(TransparentJPanel tasksPanel) throws Exception {

        UIManager.put("Panel.opaque", Boolean.TRUE);
        Font lblCountFont = new Font("Italic", Font.PLAIN, 72);
        Font lbldescriptionFont = new Font("Italic", Font.PLAIN, 24);
        UIManager.put("Label.font", lbldescriptionFont);

        // new tasks
        int panelsWidth = Start.wwidth / 5;
        DrawPanel NewTasks = new DrawPanel();
        NewTasks.setLayout(new BoxLayout(NewTasks, BoxLayout.PAGE_AXIS));
        NewTasks.setPreferredSize(new Dimension(panelsWidth, panelsWidth/50*37));
        Line line = new Line(247, 188, 49);

        JPanel newTasks = new JPanel();
        newTasks.setPreferredSize(new Dimension(panelsWidth, panelsWidth/50*32));
        newTasks.setLayout(new BoxLayout(newTasks, BoxLayout.PAGE_AXIS));
        newTasks.setVisible(true);
        JPanel upperTaskPanel = new JPanel();
        JPanel bottomTaskPanel = new JPanel();
        newTasks.add(upperTaskPanel);
        newTasks.add(Box.createVerticalGlue());
        newTasks.add(bottomTaskPanel);
        upperTaskPanel.setLayout(new BoxLayout(upperTaskPanel, BoxLayout.LINE_AXIS));
        bottomTaskPanel.setLayout(new BoxLayout(bottomTaskPanel, BoxLayout.LINE_AXIS));


        UIManager.put("Label.foreground", new Color(247, 188, 49, 255));
        newTaskName = new JLabel();
        newTaskName.setText("Нові задачі");
        newTaskCount = new JLabel();
        newTaskCount.setText("150");
        newTaskCount.setFont(new Font("Arial", Font.PLAIN, 56));
        newTaskProcent = new JLabel();
        newTaskProcent.setFont(new Font("Arial", Font.PLAIN, 28));
        newTaskProcent.setText("100%");
        upperTaskPanel.add(newTaskName);
        upperTaskPanel.add(Box.createHorizontalGlue());
        bottomTaskPanel.add(newTaskCount);
        bottomTaskPanel.add(Box.createHorizontalGlue());
        bottomTaskPanel.add(newTaskProcent);
        newTasks.setVisible(true);
        NewTasks.add(line);
        NewTasks.add(newTasks);
        NewTasks.add(Box.createHorizontalGlue());
        tasksPanel.add(NewTasks);

        // in process

        DrawPanel InProcess = new DrawPanel();
        InProcess.setPreferredSize(new Dimension(panelsWidth, panelsWidth/50*37));
        InProcess.setLayout(new BoxLayout(InProcess, BoxLayout.PAGE_AXIS));
        Line lineX = new Line(125, 125, 125);

        JPanel inProcess = new JPanel();
        inProcess.setPreferredSize(new Dimension(panelsWidth,panelsWidth/50*32));
        inProcess.setLayout(new BoxLayout(inProcess, BoxLayout.PAGE_AXIS));
        inProcess.setVisible(true);
        JPanel upperTaskInProcessPanel = new JPanel();
        JPanel bottomTaskInProcessPanel = new JPanel();
        inProcess.add(upperTaskInProcessPanel);
        inProcess.add(Box.createVerticalGlue());
        inProcess.add(bottomTaskInProcessPanel);
        upperTaskInProcessPanel.setLayout(new BoxLayout(upperTaskInProcessPanel, BoxLayout.LINE_AXIS));
        bottomTaskInProcessPanel.setLayout(new BoxLayout(bottomTaskInProcessPanel, BoxLayout.LINE_AXIS));

        UIManager.put("Label.foreground", new Color(125, 125, 125, 255));
        TaskInProcessName = new JLabel();
        TaskInProcessName.setText("Незакінчені задачі");
        TaskInProcessCount = new JLabel();
        TaskInProcessCount.setText("150");
        TaskInProcessCount.setFont(new Font("Arial", Font.PLAIN, 56));
        TaskInProcessProcent = new JLabel();
        TaskInProcessProcent.setText("100%");
        TaskInProcessProcent.setFont(new Font("Arial", Font.PLAIN, 28));
        upperTaskInProcessPanel.add(TaskInProcessName);
        upperTaskInProcessPanel.add(Box.createHorizontalGlue());
        bottomTaskInProcessPanel.add(TaskInProcessCount);
        bottomTaskInProcessPanel.add(Box.createHorizontalGlue());
        bottomTaskInProcessPanel.add(TaskInProcessProcent);
        inProcess.setVisible(true);
        InProcess.add(lineX);
        InProcess.add(inProcess);
        InProcess.add(Box.createHorizontalGlue());
        tasksPanel.add(InProcess);

        // Success tasks

        DrawPanel SuccessTasks = new DrawPanel();
        SuccessTasks.setLayout(new BoxLayout(SuccessTasks, BoxLayout.PAGE_AXIS));
        SuccessTasks.setPreferredSize(new Dimension(panelsWidth,panelsWidth/50*37));
        Line line3 = new Line(77, 157, 24);

        JPanel successTasks = new JPanel();
        successTasks.setLayout(new BoxLayout(successTasks, BoxLayout.PAGE_AXIS));
        successTasks.setPreferredSize(new Dimension(panelsWidth, panelsWidth/50*32));
        JPanel upperSuccessPanel = new JPanel();
        JPanel bottomSuccessPanel = new JPanel();
        successTasks.add(upperSuccessPanel);
        successTasks.add(Box.createVerticalGlue());
        successTasks.add(bottomSuccessPanel);
        upperSuccessPanel.setLayout(new BoxLayout(upperSuccessPanel, BoxLayout.LINE_AXIS));
        bottomSuccessPanel.setLayout(new BoxLayout(bottomSuccessPanel, BoxLayout.LINE_AXIS));

        UIManager.put("Label.foreground", new Color(77, 157, 24,255));
        SuccessTaskName = new JLabel();
        SuccessTaskName.setText("Завершені задачі");
        SuccessTaskCount = new JLabel();
        SuccessTaskCount.setText("150");
        SuccessTaskCount.setFont(new Font("Arial", Font.PLAIN, 56));
        SuccessTaskProc = new JLabel();
        SuccessTaskProc.setFont(new Font("Arial", Font.PLAIN, 28));
        SuccessTaskProc.setText("100%");
        upperSuccessPanel.add(SuccessTaskName);
        upperSuccessPanel.add(Box.createHorizontalGlue());
        bottomSuccessPanel.add(SuccessTaskCount);
        bottomSuccessPanel.add(Box.createHorizontalGlue());
        bottomSuccessPanel.add(Box.createHorizontalGlue());

        bottomSuccessPanel.add(SuccessTaskProc);
        successTasks.setVisible(true);
        SuccessTasks.add(line3);
        SuccessTasks.add(successTasks);
        SuccessTasks.add(Box.createHorizontalGlue());
        tasksPanel.add(SuccessTasks);

        //dropped tasks

        DrawPanel DroppedTasks = new DrawPanel();
        DroppedTasks.setLayout(new BoxLayout(DroppedTasks, BoxLayout.PAGE_AXIS));
        DroppedTasks.setPreferredSize(new Dimension(panelsWidth,panelsWidth/50*37));
        Line line4 = new Line(231,52,36);

        JPanel droppedTasks = new JPanel();
        droppedTasks.setLayout(new BoxLayout(droppedTasks, BoxLayout.PAGE_AXIS));
        droppedTasks.setPreferredSize(new Dimension(panelsWidth, panelsWidth/50*32));
        JPanel upperDroppedPanel = new JPanel();
        JPanel bottomDroppedPanel = new JPanel();
        droppedTasks.add(upperDroppedPanel);
        droppedTasks.add(Box.createVerticalGlue());
        droppedTasks.add(bottomDroppedPanel);
        upperDroppedPanel.setLayout(new BoxLayout(upperDroppedPanel, BoxLayout.LINE_AXIS));
        bottomDroppedPanel.setLayout(new BoxLayout(bottomDroppedPanel, BoxLayout.LINE_AXIS));


        UIManager.put("Label.foreground", new Color(231,52,36,255));
        DroppedTaskName = new JLabel();
        DroppedTaskName.setText("Провалені задачі");
        DroppedTaskCount = new JLabel();
        DroppedTaskCount.setText("150");
        DroppedTaskCount.setFont(new Font("Arial", Font.PLAIN, 56));
        DroppedTaskProcent = new JLabel();
        DroppedTaskProcent.setText("100%");
        DroppedTaskProcent.setFont(new Font("Arial", Font.PLAIN, 28));

        upperDroppedPanel.add(DroppedTaskName);
        upperDroppedPanel.add(Box.createHorizontalGlue());
        bottomDroppedPanel.add(DroppedTaskCount);
        bottomDroppedPanel.add(Box.createHorizontalGlue());
        bottomDroppedPanel.add(DroppedTaskProcent);
        droppedTasks.setVisible(true);
        DroppedTasks.add(line4);
        DroppedTasks.add(droppedTasks);
        DroppedTasks.add(Box.createHorizontalGlue());
        tasksPanel.add(DroppedTasks);

        return tasksPanel;
    }

    TransparentJPanel updateOne(TransparentJPanel tasksPanel) throws Exception{

        int countTask = countLines();
        float local;

        int newTaskCounter = countLines("New");
        newTaskCount.setText(newTaskCounter+"");
        local = (float)newTaskCounter/countTask*100;
        newTaskProcent.setText((int)local +"%");
        System.out.println("New " + newTaskCounter);

        int InProcessTaskCounter = countLines( "In Process");
        TaskInProcessCount.setText(InProcessTaskCounter+"");
        local = (float)InProcessTaskCounter/countTask*100;
        TaskInProcessProcent.setText((int)local +"%");
        System.out.println("InProcess " + InProcessTaskCounter);

        int SuccessTaskCounter = countLines( "Done");
        SuccessTaskCount.setText(SuccessTaskCounter+"");
        local = (float)SuccessTaskCounter/countTask*100;
        SuccessTaskProc.setText((int)local +"%");
        System.out.println("SuccessTask " + SuccessTaskCounter);

        int DroppedTaskCounter = countLines( "Dropped");
        DroppedTaskCount.setText(DroppedTaskCounter+"");
        local = (float)DroppedTaskCounter/countTask*100;
        DroppedTaskProcent.setText((int)local +"%");
        System.out.println("DroppedTask " + DroppedTaskCounter);



        return tasksPanel;
    }

    int countLines(String stat) throws Exception{
        Statement statement = DB.getConnection().createStatement();
        ResultSet task = statement.executeQuery("SELECT * FROM `tasks` WHERE Performer = " + Session.sessionId + " AND status = '" + stat +"'" );

        int counter=0;
        while (task.next())
            counter++;

        return counter;
    }

    int countLines() throws Exception{
        Statement statement = DB.getConnection().createStatement();
        ResultSet task = statement.executeQuery("SELECT * FROM `tasks` WHERE Performer = " + Session.sessionId );

        int counter=0;
        while (task.next())
        {
            counter++;
        }
        return counter;
    }
}



class DrawPanel extends JPanel
{
    DrawPanel(){
        super();
        this.setBackground(new Color(1,1,1,10));
    }

    DrawPanel(int r, int g, int b, int a){
        super();
        this.setBackground(new Color(r,g,b,a));
    }
}

class Line extends Component {
    int R, G, B;
    Line(int r, int g, int b){
        this.R = r;
        this.G = g;
        this.B = b;
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(60));
        g2.setColor(new Color(R, G, B));
        g2.drawLine(0, 0, 500, 0);
    }
}

