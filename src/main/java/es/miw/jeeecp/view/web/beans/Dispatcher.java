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
        case "votar/add": {
            VotarView votarView = new VotarView();
            votarView.update();
            view = action.split("/")[0];
            request.setAttribute(view, votarView);
            
        	}
            break;
        case "votar/verVotaciones": {
            VerVotosView verVotosView = new  VerVotosView();
            verVotosView.update();
            request.setAttribute("verVotaciones", verVotosView);
            view = action.split("/")[1];
        	}
            break; 
            
        case "tema/aniadirTema":
        	view = action.split("/")[1];
            break;
            
        case "tema/autorizacion":
        	view = action.split("/")[1];
            break;
        case "tema/eliminarTema":
        	view = action.split("/")[1];
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
       case "tema/aniadirTema": { //esta peticion es lanzada por ajax de forma asincrona, por lo que no redireccionamos desde el servidor
    	     AniadirTemaView aniadirTemaView = new AniadirTemaView();	 
    	     String  jsonTema = request.getParameter("tema");
	       	 TemaEntity tema = aniadirTemaView.jsonStringToObject(TemaEntity.class,jsonTema);
	       	 aniadirTemaView.setTemaRecibidoFormulario(tema);
	       	 aniadirTemaView.process();
	       	
		     JsonObject jsonObjet = new JsonObject();
		     jsonObjet.addProperty("msg", aniadirTemaView.getMsg());
		     jsonObjet.addProperty("exito", aniadirTemaView.isExitoInserccionTema());
		      mandarRespuestaJSON(response, jsonObjet.toString());
	       
      	break;
      	
      	
      }
       case "tema/autorizacion": //esta peticion la lanzamos de forma sincrona desde el formulario de autorización, por lo que SI redireccionamos
       	   AutorizacionView autorizacionView = new AutorizacionView();
       	   autorizacionView.setCodAutorizacion(request.getParameter("codAutorizacion"));
       	   view = autorizacionView.process();
       	   if(view.equals(AutorizacionView.getEliminarTemaView())) {
       		  request.setAttribute(AutorizacionView.getEliminarTemaView(), new EliminarTemaView());
       	   }else {
       		 request.setAttribute(AutorizacionView.getAutorizacionView(), autorizacionView);
       	   }
       	   redireccionar(request, response, view);
           break;
        
        
         case "tema/eliminarTema": {
        	 EliminarTemaView eliminarTemaView = new EliminarTemaView();	 
    	     eliminarTemaView.setIdTema(Integer.parseInt(request.getParameter("idTema")));
    	     eliminarTemaView.process();
		     JsonObject jsonObjet = new JsonObject();
		     jsonObjet.addProperty("msg", eliminarTemaView.getMsg());
		     jsonObjet.addProperty("exito", eliminarTemaView.isTemaEliminado());
		     mandarRespuestaJSON(response, jsonObjet.toString());	
        	
            	break;
          }
              
        }
    }


   private void mandarRespuestaJSON(HttpServletResponse response,String json) throws IOException{
	     ServletOutputStream out =response.getOutputStream();
		 out.print(json);
	     out.flush();
		 out.close();
   }

   private void redireccionar(HttpServletRequest request, HttpServletResponse response,String view) throws ServletException, IOException{
	   this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp").
       forward(request, response);
   }

}
