
public class LibrarySingleton {

	private static LibrarySingleton instance;
    private LibraryDatabase library;

    private LibrarySingleton() {
        library = new LibraryDatabase();
    }

    public static LibrarySingleton getInstance() {
        if (instance == null) {
            instance = new LibrarySingleton();
        }
        return instance;
    }

    public LibraryDatabase getLibrary() {
        return library;
    }
}
