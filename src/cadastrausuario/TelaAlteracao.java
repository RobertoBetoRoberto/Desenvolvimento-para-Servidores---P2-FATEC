package cadastrausuario;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaAlteracao extends JFrame {

    private final JPanel tela;
    private final JTextField txtNome;
    private final JPasswordField passAtual;
    private final JPasswordField passSenha;
    private final JPasswordField confPassSenha;
    private boolean atualizacaoValida;

    public TelaAlteracao() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Alteração - LojaJogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 426, 240);

        tela = new JPanel();
        tela.setBackground(SystemColor.gray);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblIdentificacao = new JLabel("Informar campos para alteração");
        lblIdentificacao.setBounds(60, 0, 500, 39);
        lblIdentificacao.setFont(new Font("Arial", 3, 19));
        tela.add(lblIdentificacao);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(24, 35, 100, 15);
        tela.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 35, 218, 20);
        tela.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblSenhaAtual = new JLabel("Senha Atual");
        lblSenhaAtual.setBounds(24, 60, 70, 15);
        tela.add(lblSenhaAtual);

        passAtual = new JPasswordField();
        passAtual.setBounds(120, 60, 219, 19);
        tela.add(passAtual);

        JLabel lblNovaSenha = new JLabel("Nova Senha");
        lblNovaSenha.setBounds(24, 85, 70, 15);
        tela.add(lblNovaSenha);

        passSenha = new JPasswordField();
        passSenha.setBounds(120, 85, 219, 19);
        tela.add(passSenha);

        JLabel lblConfSenha = new JLabel("Confirmar Senha");
        lblConfSenha.setBounds(24, 110, 100, 15);
        tela.add(lblConfSenha);

        confPassSenha = new JPasswordField();
        confPassSenha.setBounds(120, 110, 219, 19);
        tela.add(confPassSenha);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(200, 150, 117, 25);
        tela.add(btnAlterar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(50, 150, 117, 25);
        tela.add(btnCancelar);

        btnCancelar.addActionListener((ActionEvent e) -> {
            TelaInicio telaIni = new TelaInicio();
            telaIni.abreTela();
            dispose();
        });

        btnAlterar.addActionListener((ActionEvent e) -> {
            Usuario usu = new Usuario();
            usu.setNome(txtNome.getText());
            usu.setSenha(passSenha.getText());

            if ("".equals(usu.getNome())) {
                JOptionPane.showMessageDialog(null,
                        "Campo nome do usuário precisa ser informado!",
                        "Atenção", JOptionPane.ERROR_MESSAGE);
                txtNome.grabFocus();
            } else if ("".equals(usu.getSenha())) {
                JOptionPane.showMessageDialog(null,
                        "Campo senha precisa ser informado!",
                        "Atenção", JOptionPane.ERROR_MESSAGE);
                passSenha.grabFocus();
            } else if (!usu.verificaUsuario(Usuario.usuarioSistema, passAtual.getText())) {
                JOptionPane.showMessageDialog(null,
                        "Senha inválida, verifique!",
                        "Atenção", JOptionPane.ERROR_MESSAGE);
                passAtual.grabFocus();
            } else if (!passSenha.getText().equals(confPassSenha.getText())) {
                JOptionPane.showMessageDialog(null,
                        "Campo de Senha e Confirmação não são iguais!",
                        "Atenção", JOptionPane.ERROR_MESSAGE);
                passSenha.grabFocus();
            } else {
                atualizacaoValida = usu.alteraUsuario(txtNome.getText(), Usuario.usuarioSistema, usu.getSenha());
                Usuario.nomeUsuario = txtNome.getText();

                if (atualizacaoValida) {
                    JOptionPane.showMessageDialog(null,
                            "Dados alterados com sucesso.",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    TelaInicio telaInicio = new TelaInicio();
                    telaInicio.abreTela();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Erro ao tentar se conectar ao Banco de Dados.",
                            "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtNome.setText(Usuario.nomeUsuario);
    }

    public void abreTela() {
        TelaAlteracao telaAlteracao = new TelaAlteracao();
        telaAlteracao.setVisible(true);
    }
}