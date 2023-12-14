import java.util.ArrayList;
import java.util.List;

public class GeneratorVert {
    private List<Point> points;
    private List<Point> edges;
    private double l;
    private double h;
    private double d;
    private double lc;
    private double rc;
    final private double W = 0.25;

    public GeneratorVert(double l, double h, double d, double lc, double rc) {
        this.points = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.l = l;
        this.h = h;
        this.d = d;
        this.lc = lc;
        this.rc = rc;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void generatorVertices() {
        points.add(new Point(0, 0, W));
        points.add(new Point(0, 0, -W));
        points.add(new Point(l - 4.5 * lc, 0, W));
        points.add(new Point(l - 4.5 * lc, 0, -W));
        points.add(new Point(l - 3.5 * lc, 0, W));
        points.add(new Point(l - 3.5 * lc, 0, -W));
        points.add(new Point(l - 2.5 * lc, 0, W));
        points.add(new Point(l - 2.5 * lc, 0, -W));
        points.add(new Point(l - 1.5 * lc, 0, W));
        points.add(new Point(l - 1.5 * lc, 0, -W));
        points.add(new Point(l, 0, W));
        points.add(new Point(l, 0, -W));
        points.add(new Point(l, h, W));
        points.add(new Point(l, h, -W));
        points.add(new Point(l - 1.5 * lc, h, W));
        points.add(new Point(l - 1.5 * lc, h, -W));
        points.add(new Point(l - 2.5 * lc, h, W));
        points.add(new Point(l - 2.5 * lc, h, -W));
        points.add(new Point(l - 3.5 * lc, h, W));
        points.add(new Point(l - 3.5 * lc, h, -W));
        points.add(new Point(l - 4.5 * lc, h, W));
        points.add(new Point(l - 4.5 * lc, h, -W));
        points.add(new Point(0, h, W));
        points.add(new Point(0, h, -W));

        points.add(new Point(l - 4 * lc - d / (2 * 1.414), h - rc - d / (2 * 1.414), W));
        points.add(new Point(l - 4 * lc - d / (2 * 1.414), h - rc - d / (2 * 1.414), -W));
        points.add(new Point(l - 4 * lc + d / (2 * 1.414), h - rc - d / (2 * 1.414), W));
        points.add(new Point(l - 4 * lc + d / (2 * 1.414), h - rc - d / (2 * 1.414), -W));
        points.add(new Point(l - 4 * lc - d / (2 * 1.414), h - rc + d / (2 * 1.414), W));
        points.add(new Point(l - 4 * lc - d / (2 * 1.414), h - rc + d / (2 * 1.414), -W));
        points.add(new Point(l - 4 * lc + d / (2 * 1.414), h - rc + d / (2 * 1.414), W));
        points.add(new Point(l - 4 * lc + d / (2 * 1.414), h - rc + d / (2 * 1.414), -W));

        points.add(new Point(l - 3 * lc - d / (2 * 1.414), rc - d / (2 * 1.414), W));
        points.add(new Point(l - 3 * lc - d / (2 * 1.414), rc - d / (2 * 1.414), -W));
        points.add(new Point(l - 3 * lc + d / (2 * 1.414), rc - d / (2 * 1.414), W));
        points.add(new Point(l - 3 * lc + d / (2 * 1.414), rc - d / (2 * 1.414), -W));
        points.add(new Point(l - 3 * lc - d / (2 * 1.414), rc + d / (2 * 1.414), W));
        points.add(new Point(l - 3 * lc - d / (2 * 1.414), rc + d / (2 * 1.414), -W));
        points.add(new Point(l - 3 * lc + d / (2 * 1.414), rc + d / (2 * 1.414), W));
        points.add(new Point(l - 3 * lc + d / (2 * 1.414), rc + d / (2 * 1.414), -W));

        points.add(new Point(l - 2 * lc - d / (2 * 1.414), h - rc - d / (2 * 1.414), W));
        points.add(new Point(l - 2 * lc - d / (2 * 1.414), h - rc - d / (2 * 1.414), -W));
        points.add(new Point(l - 2 * lc + d / (2 * 1.414), h - rc - d / (2 * 1.414), W));
        points.add(new Point(l - 2 * lc + d / (2 * 1.414), h - rc - d / (2 * 1.414), -W));
        points.add(new Point(l - 2 * lc - d / (2 * 1.414), h - rc + d / (2 * 1.414), W));
        points.add(new Point(l - 2 * lc - d / (2 * 1.414), h - rc + d / (2 * 1.414), -W));
        points.add(new Point(l - 2 * lc + d / (2 * 1.414), h - rc + d / (2 * 1.414), W));
        points.add(new Point(l - 2 * lc + d / (2 * 1.414), h - rc + d / (2 * 1.414), -W));
    }

    public void generatorEdges() {
        edges.add(new Point(l - 4 * lc, h - rc + d / 2, W));
        edges.add(new Point(l - 4 * lc, h - rc + d / 2, -W));
        edges.add(new Point(l - 4 * lc + d / 2, h - rc, W));
        edges.add(new Point(l - 4 * lc + d / 2, h - rc, -W));
        edges.add(new Point(l - 4 * lc, h - rc - d / 2, W));
        edges.add(new Point(l - 4 * lc, h - rc - d / 2, -W));
        edges.add(new Point(l - 4 * lc - d / 2, h - rc, W));
        edges.add(new Point(l - 4 * lc - d / 2, h - rc, -W));

        edges.add(new Point(l - 3 * lc, rc + d / 2, W));
        edges.add(new Point(l - 3 * lc, rc + d / 2, -W));
        edges.add(new Point(l - 3 * lc + d / 2, rc, W));
        edges.add(new Point(l - 3 * lc + d / 2, rc, -W));
        edges.add(new Point(l - 3 * lc, rc - d / 2, W));
        edges.add(new Point(l - 3 * lc, rc - d / 2, -W));
        edges.add(new Point(l - 3 * lc - d / 2, rc, W));
        edges.add(new Point(l - 3 * lc - d / 2, rc, -W));

        edges.add(new Point(l - 2 * lc, h - rc + d / 2, W));
        edges.add(new Point(l - 2 * lc, h - rc + d / 2, -W));
        edges.add(new Point(l - 2 * lc + d / 2, h - rc, W));
        edges.add(new Point(l - 2 * lc + d / 2, h - rc, -W));
        edges.add(new Point(l - 2 * lc, h - rc - d / 2, W));
        edges.add(new Point(l - 2 * lc, h - rc - d / 2, -W));
        edges.add(new Point(l - 2 * lc - d / 2, h - rc, W));
        edges.add(new Point(l - 2 * lc - d / 2, h - rc, -W));
    }

    public String pointsToString() {
        StringBuilder export = new StringBuilder();
        for (int i = 0; i < points.size(); i++) {
            export.append("(").append(points.get(i).getX()).append(" ").append(points.get(i).getY()).append(" ").append(points.get(i).getZ()).append(") //").append(i).append("\n");
        }
        return export.toString();
    }

    public String edgesToString() {

        return "arc 28 30 " + "(" + edges.get(0).getX() + " " + edges.get(0).getY() + " " + edges.get(0).getZ() + ")\n" +
               "arc 29 31 " + "(" + edges.get(1).getX() + " " + edges.get(1).getY() + " " + edges.get(1).getZ() + ")\n" +
               "arc 26 30 " + "(" + edges.get(2).getX() + " " + edges.get(2).getY() + " " + edges.get(2).getZ() + ")\n" +
               "arc 27 31 " + "(" + edges.get(3).getX() + " " + edges.get(3).getY() + " " + edges.get(3).getZ() + ")\n" +
               "arc 24 26 " + "(" + edges.get(4).getX() + " " + edges.get(4).getY() + " " + edges.get(4).getZ() + ")\n" +
               "arc 25 27 " + "(" + edges.get(5).getX() + " " + edges.get(5).getY() + " " + edges.get(5).getZ() + ")\n" +
               "arc 24 28 " + "(" + edges.get(6).getX() + " " + edges.get(6).getY() + " " + edges.get(6).getZ() + ")\n" +
               "arc 25 29 " + "(" + edges.get(7).getX() + " " + edges.get(7).getY() + " " + edges.get(7).getZ() + ")\n" +
               "arc 36 38 " + "(" + edges.get(8).getX() + " " + edges.get(8).getY() + " " + edges.get(8).getZ() + ")\n" +
               "arc 37 39 " + "(" + edges.get(9).getX() + " " + edges.get(9).getY() + " " + edges.get(9).getZ() + ")\n" +
               "arc 34 38 " + "(" + edges.get(10).getX() + " " + edges.get(10).getY() + " " + edges.get(10).getZ() + ")\n" +
               "arc 35 39 " + "(" + edges.get(11).getX() + " " + edges.get(11).getY() + " " + edges.get(11).getZ() + ")\n" +
               "arc 32 34 " + "(" + edges.get(12).getX() + " " + edges.get(12).getY() + " " + edges.get(12).getZ() + ")\n" +
               "arc 33 35 " + "(" + edges.get(13).getX() + " " + edges.get(13).getY() + " " + edges.get(13).getZ() + ")\n" +
               "arc 32 36 " + "(" + edges.get(14).getX() + " " + edges.get(14).getY() + " " + edges.get(14).getZ() + ")\n" +
               "arc 33 37 " + "(" + edges.get(15).getX() + " " + edges.get(15).getY() + " " + edges.get(15).getZ() + ")\n" +
               "arc 44 46 " + "(" + edges.get(16).getX() + " " + edges.get(16).getY() + " " + edges.get(16).getZ() + ")\n" +
               "arc 45 47 " + "(" + edges.get(17).getX() + " " + edges.get(17).getY() + " " + edges.get(17).getZ() + ")\n" +
               "arc 42 46 " + "(" + edges.get(18).getX() + " " + edges.get(18).getY() + " " + edges.get(18).getZ() + ")\n" +
               "arc 43 47 " + "(" + edges.get(19).getX() + " " + edges.get(19).getY() + " " + edges.get(19).getZ() + ")\n" +
               "arc 40 42 " + "(" + edges.get(20).getX() + " " + edges.get(20).getY() + " " + edges.get(20).getZ() + ")\n" +
               "arc 41 43 " + "(" + edges.get(21).getX() + " " + edges.get(21).getY() + " " + edges.get(21).getZ() + ")\n" +
               "arc 40 44 " + "(" + edges.get(22).getX() + " " + edges.get(22).getY() + " " + edges.get(22).getZ() + ")\n" +
               "arc 41 45 " + "(" + edges.get(23).getX() + " " + edges.get(23).getY() + " " + edges.get(23).getZ() + ")\n";
    }
}
