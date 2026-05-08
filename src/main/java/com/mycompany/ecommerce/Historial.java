package com.mycompany.ecommerce;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Historial extends JFrame {
    //-------- Paleta------
    static final Color BG_CaRD = new Color(20,20,28);
    static final Color ACCENT = new Color (204, 30, 30);
    static final Color TEXT_PRI = new Color (245,245,245);
    static final Color TEXT_sec = new Color(160,160,175);
    static final Color Border_Clr = new Color(60,60,75);
    
    private static final Map<String, ArrayList<String>> historialGlobal = new LinkedHashMap<>();
    static void registrarCompra(String usuario, String resumen){
    
        historialGlobal.computeIfAbsent(usuario, k  -> new ArrayList<>()).add(resumen);
        
    }
    public Historial(String usuario, String rol){
    
        setTitle("Historial de Compras");
        setSize(620,520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(null){
        
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                GradientPaint gp = new GradientPaint(
                    0, 0,           new Color(14, 14, 20),
                    0, getHeight(), new Color(6,  6,  10));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(ACCENT);
                g2.setStroke(new BasicStroke(3f));
                g2.drawLine(0, 60, getWidth(), 60);
                g2.dispose(); 
                
            }
        };
        panel.setOpaque(true);
        
        //---Titulo
        
        JLabel titulo = new JLabel("Historial de Comptras");
        titulo.setBounds(0,12,620,36);
        titulo.setForeground(TEXT_PRI);
        titulo.setFont(new Font("", Font.BOLD,18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);
        
        //Area del texto
        
        JTextArea area = new JTextArea();
        area.setBackground(new Color(15,15,20));
        area.setForeground(new Color(200,210,220));
        area.setFont(new Font("Consolas", Font.PLAIN,13));
        area.setEditable(false);
        area.setBorder(BorderFactory.createEmptyBorder(10,12,10,12));
        
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20,75,580,390);
        scroll.setBorder(BorderFactory.createLineBorder(new Color (60,60,75),1));
        scroll.getViewport().setBackground(new Color(15, 15, 20));
        panel.add(scroll);
        
        StringBuilder sb = new StringBuilder();
        
        if(rol.equals("admin")){
            if(historialGlobal.isEmpty()){
                sb.append("No hay compras registradas aun");
            }else{
                for(Map.Entry<String, ArrayList<String>> entry : historialGlobal.entrySet()){
                    sb.append("══════════════════════════════════════\n");
                    sb.append("  Usuario: ").append(entry.getKey()).append("\n");
                    sb.append("══════════════════════════════════════\n");
                    int num = 1;
                    for(String compra : entry.getValue()){
                        sb.append("Compra #").append(num++).append(":\n");
                        sb.append(compra).append("\n");
                    }
                
                
                }
            }
        }else{
            ArrayList<String> misCompras = historialGlobal.get(usuario);
            if(misCompras == null || misCompras.isEmpty()){
                sb.append("Aun no has realizado ninguna Compra");
            }else{
                sb.append("Tu historial, ").append(usuario).append("\n");
                int num = 1;
                for(String compra : misCompras){
                    sb.append("========================");
                    sb.append("Compra # ").append(num++).append(":\n");
                    sb.append(compra).append("\n");
                    
                }
            }
        }
        area.setText(sb.toString());
        area.setCaretPosition(0);
        
        add(panel);
        setVisible(true);
    }
}
