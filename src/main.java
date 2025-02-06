class Circle {
  int radius, minRadius, maxRadius;
  int fade;
  boolean isShrinking;
  int strokeWeight;

  Circle(int radius, int minRadius, int maxRadius, int fade, boolean isShrinking, int strokeWeight) {
    this.radius = radius;
    this.minRadius = minRadius;
    this.maxRadius = maxRadius;
    this.fade = fade;
    this.isShrinking = isShrinking;
    this.strokeWeight = strokeWeight;
  }

  void update() {
    if (isShrinking) {
      radius--;
    } else {
      radius++;
    }

    if (radius == minRadius || radius == maxRadius) {
      isShrinking = !isShrinking;
    }
  }

  void drawCircle(int x, int y) {
    noFill();
    stroke(255, 255, 255, fade);
    strokeWeight(strokeWeight);
    circle(x, y, radius);
  }
}

Circle circle1;
Circle circle2;
Circle circle3;

void setup() {
  size(1000, 1000);
  frameRate(50);
  circle1 = new Circle(0, 0, 500, 255, false, 5);
  circle2 = new Circle(50, 0, 50, 255, false, 5);
  circle3 = new Circle(500, 50, 500, 255, true, 10);
}

void draw() {
  background(0);
  circle1.update();
  circle2.update();
  circle3.update();

  circle1.drawCircle(width / 2, height / 2);
  circle2.drawCircle(width / 2, height / 2);
  circle3.drawCircle(width / 2, height / 2);
}
