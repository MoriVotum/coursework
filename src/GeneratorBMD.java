import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneratorBMD {
    public void exportBlockMeshDict(String points, String edges) {
        // write to file
        StringBuilder export = new StringBuilder();
        export.append("""
                /*--------------------------------*- C++ -*----------------------------------*\\
                  =========                 |
                  \\\\      /  F ield         | OpenFOAM: The Open Source CFD Toolbox
                   \\\\    /   O peration     | Website:  https://openfoam.org
                    \\\\  /    A nd           | Version:  11
                     \\\\/     M anipulation  |
                \\*---------------------------------------------------------------------------*/
                FoamFile
                {
                format      ascii;
                class       dictionary;
                object      blockMeshDict;
                }
                // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * //

                convertToMeters 0.01;

                vertices
                (
                """);
                export.append(points);
                export.append("""
                );

                blocks
                (
                // cylinder blocks
                hex (0 2 3 1 22 20 21 23) (30 1 30) simpleGrading (1 1 1) // 1
                hex (2 24 25 3 20 28 29 21) (30 1 30) simpleGrading (1 1 1) // 2
                hex (28 30 31 29 20 18 19 21) (30 1 30) simpleGrading (1 1 1) // 3
                hex (26 4 5 27 30 18 19 31) (30 1 30) simpleGrading (1 1 1) // 4
                hex (2 4 5 3 24 26 27 25) (30 1 30) simpleGrading (1 1 1) // 5

                hex (4 32 33 5 18 36 37 19) (30 1 30) simpleGrading (1 1 1) // 6
                hex (36 38 39 37 18 16 17 19) (30 1 30) simpleGrading (1 1 1) // 7
                hex (34 6 7 35 38 16 17 39) (30 1 30) simpleGrading (1 1 1) // 8
                hex (4 6 7 5 32 34 35 33) (30 1 30) simpleGrading (1 1 1) // 9

                hex (6 40 41 7 16 44 45 17) (30 1 30) simpleGrading (1 1 1) // 10
                hex (44 46 47 45 16 14 15 17) (30 1 30) simpleGrading (1 1 1) // 11
                hex (42 8 9 43 46 14 15 47) (30 1 30) simpleGrading (1 1 1) // 12
                hex (6 8 9 7 40 42 43 41) (30 1 30) simpleGrading (1 1 1) // 13

                hex (8 10 11 9 14 12 13 15) (30 1 30) simpleGrading (1 1 1) // 14
                );
                edges
                (
                """);
                export.append(edges);
                export.append("""
                );
                boundary
                (
                inlet
                {
                type patch;
                faces
                (
                (0 22 23 1)
                );
                }
                outlet
                {
                type patch;
                faces
                (
                (10 12 13 11)
                );
                }
                wall
                {
                type wall;
                faces
                (
                (22 20 21 23)
                (20 18 19 21)
                (18 16 17 19)
                (16 14 15 17)
                (14 12 13 15)

                (0 2 3 1)
                (2 4 5 3)
                (4 6 7 5)
                (6 8 9 7)
                (8 10 11 9)
                );
                }
                cylinder_1
                {
                type wall;
                faces
                (
                (24 28 29 25)
                (28 30 31 29)
                (26 30 31 27)
                (24 26 27 25)
                );

                }
                cylinder_2
                {
                type wall;
                faces
                (
                (32 36 37 33)
                (36 38 39 37)
                (34 38 39 35)
                (32 34 35 33)
                );

                }
                cylinder_3
                {
                type wall;
                faces
                (
                (40 44 45 41)
                (44 46 47 45)
                (42 46 47 43)
                (40 42 43 41)
                );

                }
                frontAndBack
                {
                type empty;
                faces
                (
                (1 23 21 3)

                (3 21 29 25)
                (29 21 19 31)
                (27 31 19 5)
                (3 25 27 5)

                (5 19 37 33)
                (37 19 17 39)
                (35 39 17 7)
                (5 33 35 7)

                (7 17 45 41)
                (45 17 15 47)
                (43 47 15 9)
                (7 41 43 9)

                (0 22 20 2)

                (2 20 28 24)
                (28 20 18 30)
                (26 30 18 4)
                (2 24 26 4)

                (4 18 36 32)
                (36 18 16 38)
                (34 38 16 6)
                (4 32 34 6)

                (6 16 44 40)
                (44 16 14 46)
                (42 46 14 8)
                (6 40 42 8)
                );
                }
                );""");

        // export export to file
        try(FileWriter writer = new FileWriter("calculate/system/blockMeshDict", false))
        {
            writer.write(export.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
