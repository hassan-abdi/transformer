package com.ha.transformers.domain;

public class BattleEvent {
    public enum Type {SETUP, START, END, WINNER}
    private final Type type;

    public BattleEvent(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "BattleEvent{" +
                "type=" + type +
                '}';
    }

    public static class WinnerEvent extends BattleEvent{
        private final Team winner;
        public WinnerEvent(Team winner) {
            super(Type.WINNER);
            this.winner = winner;
        }

        public Team getWinner() {
            return winner;
        }

        @Override
        public String toString() {
            return "WinnerEvent{" +
                    "type=" + super.type +
                    ", winner=" + winner +
                    '}';
        }
    }
}
