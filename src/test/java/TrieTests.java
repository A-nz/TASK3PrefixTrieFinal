import org.junit.jupiter.api.Test;
import ru.vsu.cs.g41.petrov_a_a.Trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TrieTests {

    @Test
    public void createEmptyTrieNoElements() {
        Trie trie = new Trie();
        assertFalse(trie.isEmpty());
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("cup");
        trie.insert("college");
        trie.insert("park");
        trie.insert("Leonid");
        trie.insert("non");
        trie.insert("Zombie");

        return trie;
    }

    @Test
    public void checkingTreeIsFull() {
        Trie trie = createExampleTrie();
        assertFalse(trie.isEmpty());
    }

    @Test
    public void searchElements() {
        Trie trie = createExampleTrie();

        assertFalse(trie.searchNode("neLeonid"));
        assertFalse(trie.searchNode("university"));

        assertTrue(trie.searchNode("cup"));
        assertTrue(trie.searchNode("park"));
        assertTrue(trie.searchNode("college"));
        assertTrue(trie.searchNode("Leonid"));
        assertTrue(trie.searchNode("Zombie"));
        assertTrue(trie.searchNode("non"));
    }

    @Test
    public void searchNonExistingElement() {
        Trie trie2 = createExampleTrie();
        assertFalse(trie2.searchNode("hell"));
    }

    @Test
    public void checkDelete() {
        Trie trie = createExampleTrie();

        assertTrue(trie.searchNode("Zombie"));
        trie.delete("Zombie");

        assertFalse(trie.searchNode("Zombie"));
    }

    @Test
    public void checkDelete2() {
        Trie trie1 = new Trie();

        trie1.insert("pie");
        trie1.insert("pies");
        trie1.delete("pies");

        assertTrue(trie1.searchNode("pie"));
        assertFalse(trie1.searchNode("pies"));
    }

}
