package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ReturnBookTest {
    @Test
    void testShouldCheckIfReturnBookIsInvoked() {
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook(library);

        returnBook.execute();

        verify(library, times(1)).returnBook("Agile");
    }

}