package com.cn.drools.pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @Author: helisen
 * @Date 2021/9/22 14:46
 * @Description:
 */
public class State {
    public static final int NOTRUN = 0;
    public static final int FINISHED = 1;

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public String name;
    public int state;

    public State() {
    }

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getState() {
        return state;
    }

    public void setState(final int newState) {
        final int oldState = this.state;
        this.state = newState;
        this.changes.firePropertyChange("state", oldState, newState);
    }

    public boolean inState(final String name, final int state) {
        return this.name.equals(name) && this.state == state;
    }

    public String toString() {
        switch ( this.state ) {
            case NOTRUN :
                return this.name + "[" + "NOTRUN" + "]";
            case FINISHED :
            default :
                return this.name + "[" + "FINISHED" + "]";
        }
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        this.changes.addPropertyChangeListener(listener);
    }

    public void removePropertyListener(final PropertyChangeListener listener) {
        this.changes.removePropertyChangeListener(listener);
    }
}
