import java.io.FileWriter;
import java.io.IOException;

public class GeneratorU {
    public void exportU(String speed) {
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
                class       volVectorField;
                location    "0";
                object      U;
               }
               // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * //
               
               dimensions      [0 1 -1 0 0 0 0];
               
               internalField   uniform (0 0 0);
               
               boundaryField
               {
                inlet
                {
                    type            fixedValue;
                    value           uniform (""");
        export.append(speed);
        export.append("""
                0 0);
                }
                outlet
                {
                    type            zeroGradient;
                }
                wall
                {
                    type            fixedValue;
                    value           uniform (0 0 0);
                }
                cylinder_1
                {
                    type            fixedValue;
                    value           uniform (0 0 0);
                }
                cylinder_2
                {
                    type            fixedValue;
                    value           uniform (0 0 0);
                }
                cylinder_3
                {
                    type            fixedValue;
                    value           uniform (0 0 0);
                }
                frontAndBack
                {
                    type            empty;
                }
               }
               
               
               // ************************************************************************* //
               """);

        try(FileWriter writer = new FileWriter("calculate/0/U", false))
        {
            writer.write(export.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
