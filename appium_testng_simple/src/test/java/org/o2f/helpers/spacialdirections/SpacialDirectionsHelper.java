package org.o2f.helpers.spacialdirections;

public class SpacialDirectionsHelper {

    private SpacialDirectionsHelper(){}

    public static void verticalCoordinateVerification(int downYCoordinate, int upYCoordinate){
        /*
        Where the (0,0) point is in the upper left corner
        - downYCoordinate: most vertical distant coordinate from the origin within the touchscreen reticule
        - upYCoordinate: less distant vertical coordinate from the origin or origin itself
         */
        coordinateVerification(downYCoordinate, upYCoordinate);
    }

    public static void horizontalCoordinateVerification(int rightXCoordinate, int leftXCoordinate){
        /*
        Where the (0,0) point is in the upper left corner
        - rightXCoordinate: most horizontal distant coordinate from the origin within the touchscreen reticule
        - leftXCoordinate: less distant horizontal coordinate from the origin or origin itself
         */
        coordinateVerification(rightXCoordinate, leftXCoordinate);
    }

    private static void coordinateVerification(int farOriginDimension, int nearOriginDimension){
        /*
        Try not to use directly this method since its signature it is not too well represented.
        Instead, use verticalCoordinateVerification or horizontalCoordinateVerification that have already depicted the
        verification with the correct value in mind.
         */

        if (farOriginDimension < 0 || nearOriginDimension < 0){
            throw new RuntimeException("At least one of the provided dimension is less than 0");
        }

        if (farOriginDimension - nearOriginDimension < 0){
            throw new RuntimeException("The provided dimensions are invalid or in misplaced order");
        }

    }
}
