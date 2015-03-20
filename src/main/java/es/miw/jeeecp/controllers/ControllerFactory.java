package es.miw.jeeecp.controllers;

public abstract class ControllerFactory {
    public abstract  VotarController getVotarController();
    public abstract  VerVotacionesController getVerVotacionesController();

}
