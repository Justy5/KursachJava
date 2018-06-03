import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RegisterForm extends Login{
    void callReg(JFrame parent){
        loginLbl.setText("Реєстрація");

        loginPanel.removeAll();

        JPanel namePanel = new JPanel();
        JPanel login = new JPanel();
        JPanel email = new JPanel();
        JPanel password = new JPanel();
        JPanel repassword = new JPanel();

        loginBtnPanel.removeAll();
        forRegPanel.removeAll();
        JButton reg = new JButton("Зберегти");
        loginBtnPanel.add(reg);


        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.PAGE_AXIS));
        login.setLayout(new BoxLayout(login, BoxLayout.PAGE_AXIS));
        email.setLayout(new BoxLayout(email, BoxLayout.PAGE_AXIS));
        password.setLayout(new BoxLayout(password, BoxLayout.PAGE_AXIS));
        repassword.setLayout(new BoxLayout(repassword, BoxLayout.PAGE_AXIS));

        JLabel namelbl = new JLabel("Ім'я");
        namelbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        JTextField name = new JTextField();
        name.setAlignmentX(Label.LEFT_ALIGNMENT);
        name.setPreferredSize(new Dimension(250,30));
        name.setMaximumSize(new Dimension(250,30));
        name.setMinimumSize(new Dimension(250,30));
        namePanel.add(namelbl);
        namePanel.add(name);

        JLabel loginLbl = new JLabel("Логін (ім'я для входу)");
        loginLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        JTextField Login = new JTextField();
        Login.setAlignmentX(Label.LEFT_ALIGNMENT);
        Login.setPreferredSize(new Dimension(250,30));
        Login.setMaximumSize(new Dimension(250,30));
        Login.setMinimumSize(new Dimension(250,30));
        login.add(loginLbl);
        login.add(Login);

        JLabel emailLbl = new JLabel("Email");
        emailLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        JTextField Email = new JTextField();
        Email.setAlignmentX(Label.LEFT_ALIGNMENT);
        Email.setPreferredSize(new Dimension(250,30));
        Email.setMaximumSize(new Dimension(250,30));
        Email.setMinimumSize(new Dimension(250,30));
        email.add(emailLbl);
        email.add(Email);

        JLabel passwordLbl = new JLabel("Пароль");
        passwordLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        JPasswordField Password = new JPasswordField();
        Password.setAlignmentX(Label.LEFT_ALIGNMENT);
        Password.setPreferredSize(new Dimension(250,30));
        Password.setMaximumSize(new Dimension(250,30));
        Password.setMinimumSize(new Dimension(250,30));
        password.add(passwordLbl);
        password.add(Password);

        JLabel rePasswordLbl = new JLabel("Повторіть пароль");
        rePasswordLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        JPasswordField RePassword = new JPasswordField();
        RePassword.setAlignmentX(Label.LEFT_ALIGNMENT);
        RePassword.setPreferredSize(new Dimension(250,30));
        RePassword.setMaximumSize(new Dimension(250,30));
        RePassword.setMinimumSize(new Dimension(250,30));
        repassword.add(rePasswordLbl);
        repassword.add(RePassword);

        loginPanel.add(namePanel);
        loginPanel.add(Box.createRigidArea(new Dimension(7,7)));
        loginPanel.add(login);
        loginPanel.add(Box.createRigidArea(new Dimension(7,7)));
        loginPanel.add(email);
        loginPanel.add(Box.createRigidArea(new Dimension(7,7)));
        loginPanel.add(password);
        loginPanel.add(Box.createRigidArea(new Dimension(7,7)));
        loginPanel.add(repassword);

        reg.addActionListener(e -> {

        });

        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                parent.show();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        f.show();

    }
}
