package interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import usuario.estudiante;  
import actividades.Activity;  

public class HacerActividad {

    private estudiante estudiante;  

    public HacerActividad(estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void mostrarVentana() {
        // Crear la ventana para hacer una actividad
        JFrame hacerActividadFrame = new JFrame("Hacer Actividad");
        hacerActividadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hacerActividadFrame.setSize(500, 400);
        hacerActividadFrame.setLayout(null);

        // Etiqueta para mostrar el progreso
        JLabel progresoLabel = new JLabel("Progreso: " + estudiante.getProgreso() + "%");
        progresoLabel.setBounds(50, 20, 300, 30);
        hacerActividadFrame.add(progresoLabel);

        // Lista de actividades asignadas
        JList<String> actividadesList = new JList<>();
        DefaultListModel<String> actividadesModel = new DefaultListModel<>();

        // Llenar la lista con las actividades asignadas al estudiante
        for (Activity actividad : estudiante.getActividadesAsignadas()) {
            actividadesModel.addElement(actividad.getTitulo());
        }

        actividadesList.setModel(actividadesModel);
        JScrollPane scrollPane = new JScrollPane(actividadesList);
        scrollPane.setBounds(50, 60, 400, 200);
        hacerActividadFrame.add(scrollPane);

        // Botón para completar la actividad seleccionada
        JButton completarButton = new JButton("Completar Actividad");
        completarButton.setBounds(150, 280, 200, 30);
        hacerActividadFrame.add(completarButton);

        // Acción para el botón de completar actividad
        completarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la actividad seleccionada
                int selectedIndex = actividadesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Activity actividadSeleccionada = estudiante.getActividadesAsignadas().get(selectedIndex);
                    estudiante.completarActividad(actividadSeleccionada);

                    // Actualizar el progreso
                    float nuevoProgreso = estudiante.getProgreso() + 10.0f;  // Aumentar 10% por actividad completada
                    if (nuevoProgreso > 100) {
                        nuevoProgreso = 100; // No dejar que el progreso exceda el 100%
                    }
                    estudiante.actualizarProgreso(nuevoProgreso);

                    JOptionPane.showMessageDialog(hacerActividadFrame, "¡Actividad completada!");
                    progresoLabel.setText("Progreso: " + estudiante.getProgreso() + "%");
                } else {
                    JOptionPane.showMessageDialog(hacerActividadFrame, "Por favor, selecciona una actividad.");
                }
            }
        });

        // Hacer visible la ventana de hacer actividad
        hacerActividadFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Suponiendo que ya tienes un objeto Estudiante creado con actividades asignadas
        estudiante estudiante = new estudiante("Carlos García", "carlos@ejemplo.com", "abcd");

        // Crear algunas actividades

        HacerActividad hacerActividad = new HacerActividad(estudiante);
        hacerActividad.mostrarVentana();
    }
}
