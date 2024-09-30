import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(5, 6));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(1, 3));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(6, 7));
        rectangles.add(new Rectangle(2, 1));
        rectangles.add(new Rectangle(10, 1));

        BigRectangleFilter filter = new BigRectangleFilter();
        System.out.println("Rectangles with perimeter > 10:");
        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                System.out.println(rect);
            }
        }
    }
}