package arena;

import java.util.ArrayList;
import java.util.List;

/** ArenaData - клас у якому записуються арени */
public class ArenaData {
    private final List<Arena> arenas = new ArrayList<>();

    public ArenaData() {
        // Додати базові арени
        arenas.add(new Arena("Пустеля Татуїна", 0.05));
        arenas.add(new Arena("Міські руїни", 0.40));
        arenas.add(new Arena("Джунглі", 0.30));
        arenas.add(new Arena("Гори", 0.15));
    }

    public List<Arena> getArenas() {
        return arenas;
    }

    public void addArena(Arena arena) {
        arenas.add(arena);
    }
}
