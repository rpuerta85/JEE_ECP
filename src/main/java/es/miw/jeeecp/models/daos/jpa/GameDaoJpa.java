package es.miw.jeeecp.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.daos.GameDao;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDaoJpa extends GenericDaoJpa<GameEntity, Integer> implements GameDao {

    public GameDaoJpa() {
        super(GameEntity.class);
    }

    @Override
    public List<String> findPlayerGameNames(PlayerEntity player) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GameEntity> query = builder.createQuery(GameEntity.class);
        // Se establece la clausula FROM
        Root<GameEntity> root = query.from(GameEntity.class);
        // Se establece la clausula SELECT
        query.select(root); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate1 = builder.equal(root.get("player").as(PlayerEntity.class), player);
        Predicate predicate2 = builder.isNotNull(root.get("name").as(String.class));
        // Se establece el WHERE
        query.where(builder.and(predicate1, predicate2));
        // Se crea el resultado
        TypedQuery<GameEntity> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(0); // Se buscan todos
        List<GameEntity> result = typedQuery.getResultList();
        entityManager.close();
        List<String> names = new ArrayList<String>();
        for (GameEntity game : result) {
            if (!names.contains(game.getName())) {
                names.add(game.getName());
            }
        }
        return names;
    }

    // @Override
    public List<GameEntity> findPlayerGames(PlayerEntity player, String gameName) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GameEntity> query = builder.createQuery(GameEntity.class);
        // Se establece la clausula FROM
        Root<GameEntity> root = query.from(GameEntity.class);
        // Se establece la clausula SELECT
        query.select(root); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate1 = builder.equal(root.get("player").as(PlayerEntity.class), player);
        Predicate predicate2 = builder.equal(root.get("name").as(String.class), gameName);
        Predicate predicate = builder.and(predicate1, predicate2);
        // Se establece el WHERE
        query.where(predicate);
        // Se crea el resultado
        TypedQuery<GameEntity> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(0); // Se buscan todos
        List<GameEntity> result = typedQuery.getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public GameEntity findPlayerGame(PlayerEntity player, String selectedNameGame) {
        List<GameEntity> sessionGames = DaoFactory.getFactory().getSessionDao()
                .findPlayerGamesOfSession(player);
        List<GameEntity> playerGames = this.findPlayerGames(player, selectedNameGame);
        for (GameEntity sessionGame : sessionGames) {
            for (int i = 0; i < playerGames.size(); i++) {
                if (playerGames.get(i).getId().equals(sessionGame.getId())) {
                    playerGames.remove(i);
                    break;
                }
            }
        }
        assert playerGames.size() == 1;
        return playerGames.get(0);
    }
}
