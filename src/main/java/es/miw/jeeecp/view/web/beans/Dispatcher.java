package es.miw.jeeecp.view.web.beans;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;

import es.miw.jeeecp.models.daos.DaoFactory;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

@WebServlet(name = "DispatcherJSP", urlPatterns = { "/jsp/*" })
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/jspPages/";

    public void init( ServletConfig conf ) throws ServletException {
		try {
			super.init( conf );
			DaoFactory factory = DaoJpaFactory.getFactory();

		} catch( ServletException e ) {
			throw new ServletException( "init" );
		}
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);
        String view="home";
        switch (action) {
        case "votar": {
            VotarView votarView = new VotarView();
            votarView.update();
            request.setAttribute(action, votarView);
            view = action;
        	}
            break;
        case "votar/verVotaciones": {
            VerVotosView verVotosView = new  VerVotosView();
            verVotosView.update();
            request.setAttribute("verVotaciones", verVotosView);
            view = action.split("/")[1];
        	}
            break; 
            
        case "persona":
            /*PersonaView personaView = new PersonaView();
            personaView.setPersona(new Persona());
            request.setAttribute(action, personaView);
            view = action;*/
            break;
        case "rol":
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);
            view = action;*/
            break;
        default:
            view = "home";
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
        case "votar":
        	
        	/* Persona persona = new Persona();
            persona.setId(Integer.valueOf(request.getParameter("id")));
            persona.setNombre(request.getParameter("nombre"));
            persona.setRol(request.getParameter("rol"));
            PersonaView personaView = new PersonaView();
            personaView.setPersona(persona);
            request.setAttribute(action, personaView);
            view = personaView.process();*/
            break;
        case "votar/add": { //esta peticion es lanzada por ajax de forma asincrona
	       	 String ip = request.getRemoteAddr();
        	 VotarView votarView = new VotarView();
	       	 String  jsonTema = request.getParameter("tema");
	       	 String  jsonVoto = request.getParameter("voto");
	       	 TemaEntity tema = votarView.jsonStringToObject(TemaEntity.class,jsonTema);
	       	 VotoEntity voto = votarView.jsonStringToObject(VotoEntity.class,jsonVoto);
	       	 voto.setIp(ip);
	       	 votarView.setTemaRecibidoFormulario(tema);
	       	 votarView.setVotoRecibidoFormulario(voto);
	       	 votarView.process();
	       	
		     JsonObject jsonObjet = new JsonObject();
		     jsonObjet.addProperty("msg", votarView.getMsg());
		     jsonObjet.addProperty("exito", votarView.getVotoInsertado());
		     mandarRespuestaJSON(response, jsonObjet.toString());
	       
       	break;
       	
       }
        case "rol":
            /*RolView rolView = new RolView();
            rolView.setRol(request.getParameter("rol"));
            request.setAttribute(action, rolView);
            view = rolView.process();*/
            break;
        }

       /* this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);*/
    }


   private void mandarRespuestaJSON(HttpServletResponse response,String json) throws IOException{
	     ServletOutputStream out =response.getOutputStream();
		 out.print(json);
	     out.flush();
		 out.close();
   }


}
