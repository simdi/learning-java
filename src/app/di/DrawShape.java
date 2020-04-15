package app.di;

public class DrawShape {
  private Shape shape;

  public DrawShape(Shape shape) {
    this.shape = shape;
  }

  public void drawShape() {
    this.shape.draw();
  }
}