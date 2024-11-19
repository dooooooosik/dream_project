loginButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = userText.getText();
        String password = new String(passwordText.getPassword());

        LoginHandler loginHandler = new LoginHandler();
        if (loginHandler.authenticate(id, password)) {
            JOptionPane.showMessageDialog(null, "로그인 성공!");
        } else {
            JOptionPane.showMessageDialog(null, "로그인 실패. 아이디와 비밀번호를 확인하세요.");
        }
    }
});

// 데이터베이스 미구현 !!!!!!!!
