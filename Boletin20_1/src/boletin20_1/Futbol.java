package boletin20_1;

import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class Futbol {

    String[] equipos = {"Celta", "Barsa", "Madrid"};
    String[] xornadas = {"X1", "X2", "X3"};
    int[][] goles = {{9, 10, 3}, {3, 4, 4}, {5, 2, 1}};
    int[] totalG = {0, 0, 0};
    int[] totalX = {0, 0, 0};

    public void amosar(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + "   ");
        }
        System.out.println("");
    }

    public void amosar(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + "   ");
        }
        System.out.println("");
    }
    
    public void totalGoles() {
        int total = 0;
        for (int f = 0; f < goles.length; f++) {
            for (int c = 0; c < goles[f].length; c++) {
                total = total + goles[f][c];
            }
            totalG[f] = total;
            total = 0;
        }
        amosar(totalG);
    }
    
    public void totalXornadas() {
        int total = 0;
        for (int c = 0; c < goles[0].length; c++) {
            for (int f = 0; f < goles.length; f++) {
                total = total + goles[f][c];
            }
            totalX[c] = total;
            total = 0;
        }
    }
    //Menú
    public void menu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Escolla unha opción:\n"
                    + "1. Gravar e imprimir a táboa\n"
                    + "2. Obter unha listaxe dos equipos por orde de menor n° de goles na liga\n"
                    + "3. Indicar o equipo que marca máis goles en cada xornada\n"
                    + "4. Que equipo e en que xornada se rexistran máis goles?\n"
                    + "5. Consultas por equipo e xornada indicando o n° de goles\n"
                    + "6. Salir"));
            switch (opcion) {
                case 1:
                    amosarTaboa();
                    break;
                case 2:
                    ordenarEquipos();
                    break;
                case 3:
                    equipoGolesXornada();
                    break;
                case 4:
                    equipoConMaisGoles();
                    break;
                case 5:
                    consulta();
                    break;
                case 6:
                    break;
            }
        } while (opcion != 6);
    }

    public void amosarTaboa() {
        System.out.print("Equipo/xornada  ");
        for (int i = 0; i < xornadas.length; i++) {
            System.out.print(xornadas[i] + "  ");
        }
        System.out.println("");
        for (int f = 0; f < goles.length; f++) {
            System.out.print(equipos[f] + "           ");
            for (int c = 0; c < goles[f].length; c++) {
                System.out.print(goles[f][c] + "   ");
            }
            System.out.println("");
        }
    }

    public void ordenarEquipos() {
        totalGoles();
        String aux1 = "";
        int aux2 = 0;
        int[] totalG2 = totalG;
        String[] ordenados = equipos;
        amosar(ordenados);
        for (int i = 0; i < totalG2.length - 1; i++) {
            for (int j = i + 1; j < totalG2.length; j++) {
                if (totalG2[i] > totalG2[j]) {
                    aux1 = ordenados[j];
                    ordenados[j] = ordenados[i];
                    ordenados[i] = aux1;
                    aux2 = totalG2[j];
                    totalG2[j] = totalG2[i];
                    totalG2[i] = aux2;
                }
            }
        }
        amosar(ordenados);
    }

    public void equipoGolesXornada() {
        int mayor = 0;
        int pos = 0;
        for (int i = 0; i < goles[0].length; i++) {
            for (int j = 0; j < goles.length; j++) {
                if (goles[j][i] > mayor) {
                    mayor = goles[j][i];
                    pos = j;
                }
            }
            JOptionPane.showMessageDialog(null, "O equipo co maior numero "
                    + "de goles da xornada " + (i + 1) + " é o " + equipos[pos]
                    + " con " + mayor + " goles");
            mayor = 0;
        }
    }

    public void equipoConMaisGoles() {
        int mayor = 0;
        int equipo = 0;
        int xornada = 0;
        for (int i = 0; i < goles[0].length; i++) {
            for (int j = 0; j < goles.length; j++) {
                if (goles[j][i] > mayor) {
                    mayor = goles[j][i];
                    equipo = j;
                    xornada = i + 1;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "O equipo co maior numero de "
                + "goles é o " + equipos[equipo] + " con "
                + mayor + " goles na xornada " + xornada);
    }

    public void consulta() {
        String equipo = JOptionPane.showInputDialog("Introduza o equipo:");
        String xornada = JOptionPane.showInputDialog("Introduza a xornada:");
        int pequipo = 0;
        int pxornada = 0;
        int comprobar = 0;
        for (int i = 0; i < equipos.length; i++) {
            if (equipo.equals(equipos[i])) {
                pequipo = i;
                comprobar++;
            }
        }
        for (int i = 0; i < xornadas.length; i++) {
            if (xornada.equals(xornadas[i])) {
                pxornada = i;
                comprobar++;
            }
        }
        if (comprobar == 2) {
            JOptionPane.showMessageDialog(null, "Equipo: " + equipo + "\nXornada: "
                    + xornada + "\nNº de goles: " + goles[pequipo][pxornada]);
        } else {
            JOptionPane.showMessageDialog(null, "Hai algun erro nos datos introducidos");
        }
    }
}
