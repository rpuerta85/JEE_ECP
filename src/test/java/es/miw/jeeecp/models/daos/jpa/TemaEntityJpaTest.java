package es.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.*;

import org.junit.Test;

import es.miw.jeeecp.models.daos.TemaDao;

public class TemaEntityJpaTest {

	    private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

	    private PieceDaoJpaTestData data;

	    @Before
	    public void inti() {
	        data = new PieceDaoJpaTestData();
	    }
	 
	    
	    @Test
	    public void testCreate() {
	        List<PieceEntity> piecesData = new ArrayList<PieceEntity>();
	        while (data.hasNextPieces()) {
	            if (data.getPiece() != null) {
	                System.out.println("!!!PIECE Id: " + data.getPiece().getId() + ": "
	                        + data.getPiece());
	                dao.create(data.getPiece());
	                piecesData.add(data.getPiece());
	            }
	            data.nextPiece();
	        }
	        List<PieceEntity> pieces = dao.findAll();
	        for (PieceEntity piece : piecesData) {
	            assertTrue(pieces.contains(piece));
	        }
	        assertTrue(pieces.size() == piecesData.size());
	    }

	    @Test
	    public void testUpdate() {

	        // dao.deleteByID(data.getPiece().getId());
	        // dao.read(data.getPiece().getId());
	        // dao.update(data.getPiece());
	    }

	    @Test
	    public void testDelete() {

	    }

	    @Test
	    public void testDeleteByID() {

	    }

	    @Test
	    public void testDeleteByCoordinate() {

	    }

	    @Test
	    public void testRead() {

	    }

	    @Test
	    public void testFindAll() {

	    }

	}
