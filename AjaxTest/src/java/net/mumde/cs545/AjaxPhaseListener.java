/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mumde.cs545;

/**
 *
 * @author 984317
 */
import javax.faces.event.PhaseListener;

import javax.faces.event.PhaseEvent;

import javax.faces.event.PhaseId;

import javax.faces.context.FacesContext;

import javax.servlet.http.*;

import java.io.*;

public class AjaxPhaseListener implements PhaseListener {

    public PhaseId getPhaseId() {    // Want to be called in the restore view phase

        return PhaseId.RESTORE_VIEW; // in afterPhase()

    }

    public void beforePhase(PhaseEvent phaseEvent) { // not interested

    }

    public void afterPhase(PhaseEvent phaseEvent) { // After the RESTORE VIEW phase

        FacesContext fc = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();

        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();

        String s = request.getServletPath();

        if (s.contains("dateAndTime.ajax?type=date")) {

            response.setContentType("text/plain");

            response.setHeader("Cache-Control", "no-cache");

            response.setStatus(HttpServletResponse.SC_OK);

            try {

                response.getWriter().write("AjaxPhaseListener: " + ((new java.util.Date()).toString()));

            } catch (Exception ex) {

                System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());

            }

            phaseEvent.getFacesContext().responseComplete();

        }

    }

}
