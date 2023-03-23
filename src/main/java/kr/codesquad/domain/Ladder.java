package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        validateLineWidth(ladderLines);
        this.ladderLines = ladderLines;
    }

    private void validateLineWidth(List<LadderLine> ladderLines) {
        if (isSameWidth(ladderLines)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private boolean isSameWidth(List<LadderLine> ladderLines) {
        if (ladderLines.size() < 1) {
            return false;
        }

        final int width = ladderLines.get(0).getSumParts();

        return ladderLines.stream()
                .mapToInt(LadderLine::getSumParts)
                .allMatch(sum -> sum == width);
    }

    public List<String> createOutputLines() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.toList());
    }

    public List<Point> makeResult() {
        final Queue<Point> points = getStartPoints();
        int maxHeight = ladderLines.size();
        int height = 0;

        while (height < maxHeight) {
            goDownLadderLine(points, height);
            ++height;
        }

        return new ArrayList<>(points);
    }

    private void goDownLadderLine(Queue<Point> points, int height) {
        final int pointCount = points.size();
        final LadderLine ladderLine = ladderLines.get(height);

        for (int i = 0 ; i < pointCount; i++) {
            Point point = points.poll();
            final Direction direction = ladderLine.findCanMoveDirection(point);
            point.move(direction.getUnitVector());
            points.offer(point);
        }
    }

    private Queue<Point> getStartPoints() {
        final Queue<Point> points = new LinkedList<>();
        final int maxWidth = ladderLines.get(0).getSumParts();

        for (int width = 0 ; width < maxWidth; width += 2) {
            points.offer(new Point(width));
        }
        return points;
    }
}
