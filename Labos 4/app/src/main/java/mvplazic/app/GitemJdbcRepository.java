package mvplazic.app;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GitemJdbcRepository implements GItemRepository{

    private final JdbcTemplate jdbc;

    public GitemJdbcRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<GroceryItem> findAll() {
        return jdbc.query("SELECT * FROM groceryItem",this::mapRow);
    }

    private GroceryItem mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new GroceryItem(
                rs.getString("name"),
                rs.getString("country"),
                rs.getInt("calories"),
                rs.getDouble("price"),
                rs.getInt("image")
        );
    }
}
