import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogsTab {
    JPanel innerPanel;
    JTextField pageField;
    int page=0;
    JPanel table, idPanel, logerPanel, subjectPanel, toSmbdPanel, timePanel;

    TransparentJPanel create(TransparentJPanel panel) throws Exception{
        UIManager.put("Panel.background", new Color(180, 208, 255));
        innerPanel = new JPanel();
        panel.add(innerPanel);
        innerPanel.setPreferredSize(new Dimension(Start.wwidth / 8 * 7, Start.wheight));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        generate(page);
        addPageScroller();
        return panel;
    }

    void generate(int page) throws Exception{
        UIManager.put("Panel.background", new Color(180, 208, 255));
        table = new JPanel();
        table.setPreferredSize(new Dimension(innerPanel.getPreferredSize().width-200, innerPanel.getPreferredSize().height-200));
        table.setMaximumSize(new Dimension(innerPanel.getPreferredSize().width-200, innerPanel.getPreferredSize().height-200));
        innerPanel.add(Box.createRigidArea(new Dimension(15,20)));
        innerPanel.add(table);

        table.setLayout(new BoxLayout(table, BoxLayout.LINE_AXIS));
        table.add(Box.createHorizontalGlue());
        table.add(Box.createHorizontalGlue());
        table.add(Box.createHorizontalGlue());

        idPanel = new JPanel();
        JLabel idLbl = new JLabel("№");
        idLbl.setAlignmentX(TextField.CENTER_ALIGNMENT);
        idPanel.add(idLbl);
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.PAGE_AXIS));
        idPanel.setMinimumSize(new Dimension(20,27));
        table.add(idPanel);

        table.add(Box.createHorizontalGlue());

        logerPanel = new JPanel();
        JLabel logerLbl = new JLabel("Логер");
        logerLbl.setAlignmentX(TextField.CENTER_ALIGNMENT);
        logerPanel.add(logerLbl);
        logerPanel.setLayout(new BoxLayout(logerPanel, BoxLayout.PAGE_AXIS));
        logerPanel.setMinimumSize(new Dimension(20,27));
        table.add(logerPanel);

        table.add(Box.createHorizontalGlue());

        subjectPanel = new JPanel();
        JLabel subjectLbl = new JLabel("Опис логу");
        subjectLbl.setAlignmentX(TextField.CENTER_ALIGNMENT);
        subjectPanel.add(subjectLbl);
        subjectPanel.setLayout(new BoxLayout(subjectPanel, BoxLayout.PAGE_AXIS));
        subjectPanel.setMinimumSize(new Dimension(20,27));
        table.add(subjectPanel);

        table.add(Box.createHorizontalGlue());

        toSmbdPanel = new JPanel();
        JLabel toSmbdLbl = new JLabel("Взаємодіє з");
        toSmbdLbl.setAlignmentX(TextField.CENTER_ALIGNMENT);
        toSmbdPanel.add(toSmbdLbl);
        toSmbdPanel.setLayout(new BoxLayout(toSmbdPanel, BoxLayout.PAGE_AXIS));
        toSmbdPanel.setMinimumSize(new Dimension(20,27));
        table.add(toSmbdPanel);

        table.add(Box.createHorizontalGlue());

        timePanel = new JPanel();
        JLabel timeLbl = new JLabel("Час");
        timeLbl.setAlignmentX(TextField.CENTER_ALIGNMENT);
        timePanel.add(timeLbl);
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.PAGE_AXIS));
        timePanel.setMinimumSize(new Dimension(20,27));
        table.add(timePanel);

        table.add(Box.createHorizontalGlue());
        table.add(Box.createHorizontalGlue());
        table.add(Box.createHorizontalGlue());

        Statement statement = DB.getConnection().createStatement();
        ResultSet res = statement.executeQuery("SELECT * from logs ORDER BY id DESC LIMIT " + page*19 + ", " + 19);
        while (res.next()){
            int localId = res.getInt(1);
            JTextField id = new JTextField(localId + "");
            id.setPreferredSize(new Dimension(20, 27));
            id.setMaximumSize(new Dimension(20, 27));
            id.setMinimumSize(new Dimension(20, 27));
            id.setAlignmentX(TextField.CENTER_ALIGNMENT);
            id.setEditable(false);
            idPanel.add(id);

            Statement statement1 = DB.getConnection().createStatement();
            ResultSet logerSet = statement1.executeQuery("SELECT manager_name FROM menegers WHERE id = " + res.getInt("loger"));
            JTextField loger = new JTextField(" ");
            loger.setPreferredSize(new Dimension(200, 27));
            loger.setMaximumSize(new Dimension(200, 27));
            loger.setMinimumSize(new Dimension(200, 27));
            loger.setAlignmentX(TextField.CENTER_ALIGNMENT);
            if(logerSet.next())
                loger.setText(logerSet.getString("manager_name"));
            loger.setEditable(false);
            logerPanel.add(loger);

            JTextField content = new JTextField(res.getString("Content"));
            content.setAlignmentX(TextField.CENTER_ALIGNMENT);
            content.setPreferredSize(new Dimension(450, 27));
            content.setMaximumSize(new Dimension(450, 27));
            content.setMinimumSize(new Dimension(450, 27));
            content.setEditable(false);
            subjectPanel.add(content);

            Statement statement2 = DB.getConnection().createStatement();
            ResultSet toSmbdSet = statement2.executeQuery("SELECT clients.Name, SurName, LastName FROM clients WHERE id = " + res.getInt("tosmbd"));
            JTextField toSmbd = new JTextField(" ");
            toSmbd.setPreferredSize(new Dimension(200, 27));
            toSmbd.setMaximumSize(new Dimension(200, 27));
            toSmbd.setMinimumSize(new Dimension(200, 27));
            toSmbd.setAlignmentX(TextField.CENTER_ALIGNMENT);
            if(toSmbdSet.next())
                toSmbd.setText(toSmbdSet.getString("SurName") + " " + toSmbdSet.getString("Name") + " " + toSmbdSet.getString("LastName"));
            toSmbd.setEditable(false);
            toSmbdPanel.add(toSmbd);

            JTextField time = new JTextField(res.getString("time"));
            time.setAlignmentX(TextField.CENTER_ALIGNMENT);
            time.setPreferredSize(new Dimension(150, 27));
            time.setMaximumSize(new Dimension(150, 27));
            time.setMinimumSize(new Dimension(150, 27));
            time.setEditable(false);
            timePanel.add(time);
        }

        idPanel.add(Box.createVerticalGlue());
        logerPanel.add(Box.createVerticalGlue());
        subjectPanel.add(Box.createVerticalGlue());
        toSmbdPanel.add(Box.createVerticalGlue());
        timePanel.add(Box.createVerticalGlue());



    }



    void addPageScroller() throws Exception{
        UIManager.put("Panel.background", new Color(180, 216, 219));
        JPanel btnPanel = new JPanel();
        JButton left = new JButton("<<");
        left.setEnabled(false);
        JButton update = new JButton("↻");
        JButton right = new JButton(">>");
        pageField = new JTextField("0");
        pageField.setEditable(false);
        left.addActionListener(e -> {
            try {
                if (page > 0) {
                    --page;
                }else
                    left.setEnabled(true);

                innerPanel.removeAll();
                innerPanel.repaint();
                this.generate(page);
                pageField.setText((page+1) + "");
                innerPanel.add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        right.addActionListener(e -> {
            try {
                left.setEnabled(true);
                ++page;

                innerPanel.removeAll();
                innerPanel.repaint();
                this.generate(page);
                pageField.setText((page+1) + "");
                innerPanel.add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        update.addActionListener(e -> {
            try {

                innerPanel.removeAll();
                innerPanel.repaint();
                this.generate(page);
                pageField.setText((page+1) + "");
                innerPanel.add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        btnPanel.add(left);

        btnPanel.add(pageField);
        btnPanel.add(right);
        btnPanel.add(update);
        pageField.setText(page+1 + "");
        innerPanel.add(btnPanel);
        innerPanel.add(Box.createVerticalGlue());

    }
}
