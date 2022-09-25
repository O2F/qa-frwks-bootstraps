package org.o2f.pages;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.o2f.helpers.spacialdirections.HorizontalDirection;
import org.o2f.helpers.spacialdirections.VerticalDirection;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

import static org.o2f.helpers.spacialdirections.SpacialDirectionsHelper.*;
import static org.o2f.helpers.spacialdirections.HorizontalDirection.LEFT;
import static org.o2f.helpers.spacialdirections.HorizontalDirection.RIGHT;
import static org.o2f.helpers.spacialdirections.VerticalDirection.DOWN;
import static org.o2f.helpers.spacialdirections.VerticalDirection.UP;

@Slf4j
public class MobileBasePage {

    /*
    A lot of methods are "hand" build in this class since the TouchActions class is becoming deprecated and there is no
    direct replacement for it,so until there (if there will be in the future), every tester needs to rebuild their
    mobile actions.
    There are two ways to do this.
    - "raw" sequence of actions (agnostic of the device used)
    - using specific android and ios commands sending them with JS
     */

    AppiumDriver driver;

    public MobileBasePage(AppiumDriver driver){
        this.driver = driver;
    }

    public void rawTap(By by){
        Point p = this.getElementCenter(by);

        log.error(String.format("Point - %s, %s", p.getX(), p.getY()));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence touch = new Sequence(finger, 1);

        touch.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), p.getX(), p.getY()));

        touch.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        touch.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(touch));

    }

    public void rawWindowVerticalSwipe(VerticalDirection direction){
        this.rawWindowVerticalSwipe(direction,0, 500, 100);
    }

    public void rawWindowVerticalSwipe(VerticalDirection vDirection,
                                       Integer vDownOffsetViewPort,
                                       Integer vUpOffsetViewPort,
                                       Integer scrollDurationMilli){
        /*
        It is always given a 100p from the initial and final viewport dimension
        This allows to have a more dynamic way to control the swipe
         */
        Dimension viewportDimension = this.getViewPortDimension();
        int defaultOffset = 100;
        int downYCoordinate = vDownOffsetViewPort == 0
                ? viewportDimension.getHeight() - defaultOffset
                :  viewportDimension.getHeight() - vDownOffsetViewPort;
        int upYCoordinate = vUpOffsetViewPort == 0
                ? defaultOffset
                : vUpOffsetViewPort;

        //safety verification
        verticalCoordinateVerification(downYCoordinate,upYCoordinate);

        int horizontalMiddle = viewportDimension.getWidth()/2; //this never changes

        if (vDirection.equals(UP)){
            rawSwipe(horizontalMiddle, downYCoordinate, horizontalMiddle, upYCoordinate, scrollDurationMilli);
        }
        if (vDirection.equals(DOWN)){
            rawSwipe(horizontalMiddle, upYCoordinate, horizontalMiddle, downYCoordinate, scrollDurationMilli);
        }
    }

    public void rawWindowHorizontalFullScreenSwipe(HorizontalDirection hDirection,
                                         Integer hLeftOffSetFromMargin,
                                         Integer hRightOffSetFromMargin,
                                         Integer swipeDurationMilli){
        /*
        Used for full screen swipe and not localized swipe. For localized swipe use "rawSwipe".
        It is always given a 10p from the left and right touchScreen margin dimension
        This allows to have a more dynamic way to control the swipe
         */
        Dimension viewportDimension = this.getViewPortDimension();
        int defaultOffset = 10;

        int leftXCoordinate = hLeftOffSetFromMargin == 0
                ?  defaultOffset
                :  hLeftOffSetFromMargin;
        int rightXCoordinate = hRightOffSetFromMargin == 0
                ? viewportDimension.getWidth() - defaultOffset
                : viewportDimension.getWidth() - hRightOffSetFromMargin;

        //safety verification
        horizontalCoordinateVerification(rightXCoordinate,leftXCoordinate);

        int verticalMiddle = viewportDimension.getHeight()/2; //this never changes

        if (hDirection.equals(LEFT)){
            rawSwipe(rightXCoordinate, verticalMiddle, leftXCoordinate, verticalMiddle, swipeDurationMilli);
        }
        if (hDirection.equals(RIGHT)){
            rawSwipe(leftXCoordinate, verticalMiddle, rightXCoordinate, verticalMiddle, swipeDurationMilli);
        }

    }

    public void rawSwipe(int initX, int initY, int finalX, int finalY, int durationMilli) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence touch = new Sequence(finger, 0);

        touch.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), initX, initY));
        touch.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        touch.addAction(new Pause(finger, Duration.ofMillis(200)));
        touch.addAction(finger.createPointerMove(Duration.ofMillis(durationMilli),
                PointerInput.Origin.viewport(), finalX, finalY));
        touch.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(touch));

    }

    public void zoom(){
        throw new NotImplementedException();
    }

    private Dimension getViewPortDimension(){
        return driver.manage().window().getSize();
    }

    private Point getElementCenter(By by){
        WebElement element = driver.findElement(by);
        Dimension dimension = element.getSize();
        Point initPoint = element.getLocation();
        return new Point(initPoint.getX() + dimension.getWidth()/2, initPoint.getY() + dimension.getHeight()/2);
    }

}
