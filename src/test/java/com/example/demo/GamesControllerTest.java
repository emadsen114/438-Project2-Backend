// package com.example.demo.entities;

// import com.example.demo.entities.Game;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Optional;

// import static org.hamcrest.Matchers.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest(BooksController.class)
// @DisplayName("Games Controller Tests")
// class BooksControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private BooksRepository booksRepository;

//     @Autowired
//     private ObjectMapper objectMapper;

//     private Book testBook1;
//     private Book testBook2;

//     @BeforeEach
//     void setUp() {
//         testBook1 = new Book("The Hobbit", "J.R.R. Tolkien");
//         testBook1.setId(1L);

//         testBook2 = new Book("1984", "George Orwell");
//         testBook2.setId(2L);
//     }

//     @Test
//     @DisplayName("GET /books should return all books")
//     void testGetAllBooks() throws Exception {
//         when(booksRepository.findAll()).thenReturn(Arrays.asList(testBook1, testBook2));

//         mockMvc.perform(get("/books"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(jsonPath("$", hasSize(2)))
//                 .andExpect(jsonPath("$[0].id", is(1)))
//                 .andExpect(jsonPath("$[0].title", is("The Hobbit")))
//                 .andExpect(jsonPath("$[0].author", is("J.R.R. Tolkien")))
//                 .andExpect(jsonPath("$[1].id", is(2)))
//                 .andExpect(jsonPath("$[1].title", is("1984")))
//                 .andExpect(jsonPath("$[1].author", is("George Orwell")));

//         verify(booksRepository, times(1)).findAll();
//     }

//     @Test
//     @DisplayName("GET /books should return empty list when no books exist")
//     void testGetAllBooksEmpty() throws Exception {
//         when(booksRepository.findAll()).thenReturn(Collections.emptyList());

//         mockMvc.perform(get("/books"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(jsonPath("$", hasSize(0)));

//         verify(booksRepository, times(1)).findAll();
//     }

//     @Test
//     @DisplayName("POST /books should create new book")
//     void testCreateBook() throws Exception {
//         Book newBook = new Book("New Book", "New Author");
//         Book savedBook = new Book("New Book", "New Author");
//         savedBook.setId(3L);

//         when(booksRepository.save(any(Book.class))).thenReturn(savedBook);

//         mockMvc.perform(post("/books")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(newBook)))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(jsonPath("$.id", is(3)))
//                 .andExpect(jsonPath("$.title", is("New Book")))
//                 .andExpect(jsonPath("$.author", is("New Author")));

//         verify(booksRepository, times(1)).save(any(Book.class));
//     }

//     @Test
//     @DisplayName("GET /books/{id} should return book when it exists")
//     void testGetBookById() throws Exception {
//         when(booksRepository.findById(1L)).thenReturn(Optional.of(testBook1));

//         mockMvc.perform(get("/books/1"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType("application/hal+json"))
//                 .andExpect(jsonPath("$.id", is(1)))
//                 .andExpect(jsonPath("$.title", is("The Hobbit")))
//                 .andExpect(jsonPath("$.author", is("J.R.R. Tolkien")))
//                 .andExpect(jsonPath("$._links.self.href", containsString("/books/1")))
//                 .andExpect(jsonPath("$._links.books.href", containsString("/books")));

//         verify(booksRepository, times(1)).findById(1L);
//     }

//     @Test
//     @DisplayName("GET /books/{id} should return 404 when book doesn't exist")
//     void testGetBookByIdNotFound() throws Exception {
//         when(booksRepository.findById(999L)).thenReturn(Optional.empty());

//         mockMvc.perform(get("/books/999"))
//                 .andExpect(status().isNotFound());

//         verify(booksRepository, times(1)).findById(999L);
//     }

//     @Test
//     @DisplayName("PUT /books/{id} should update existing book")
//     void testUpdateExistingBook() throws Exception {
//         Book updatedBook = new Book("Updated Title", "Updated Author");
//         Book existingBook = new Book("The Hobbit", "J.R.R. Tolkien");
//         existingBook.setId(1L);

//         Book savedBook = new Book("Updated Title", "Updated Author");
//         savedBook.setId(1L);

//         when(booksRepository.findById(1L)).thenReturn(Optional.of(existingBook));
//         when(booksRepository.save(any(Book.class))).thenReturn(savedBook);

//         mockMvc.perform(put("/books/1")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(updatedBook)))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(jsonPath("$.id", is(1)))
//                 .andExpect(jsonPath("$.title", is("Updated Title")))
//                 .andExpect(jsonPath("$.author", is("Updated Author")));

//         verify(booksRepository, times(1)).findById(1L);
//         verify(booksRepository, times(1)).save(any(Book.class));
//     }

//     @Test
//     @DisplayName("PUT /books/{id} should create new book when ID doesn't exist")
//     void testUpdateNonExistingBook() throws Exception {
//         Book newBook = new Book("New Book", "New Author");
//         Book savedBook = new Book("New Book", "New Author");
//         savedBook.setId(999L);

//         when(booksRepository.findById(999L)).thenReturn(Optional.empty());
//         when(booksRepository.save(any(Book.class))).thenReturn(savedBook);

//         mockMvc.perform(put("/books/999")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(newBook)))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(jsonPath("$.id", is(999)))
//                 .andExpect(jsonPath("$.title", is("New Book")))
//                 .andExpect(jsonPath("$.author", is("New Author")));

//         verify(booksRepository, times(1)).findById(999L);
//         verify(booksRepository, times(1)).save(any(Book.class));
//     }

//     @Test
//     @DisplayName("DELETE /book/{id} should delete existing book")
//     void testDeleteBook() throws Exception {
//         doNothing().when(booksRepository).deleteById(1L);

//         mockMvc.perform(delete("/book/1"))
//                 .andExpect(status().isOk());

//         verify(booksRepository, times(1)).deleteById(1L);
//     }

//     @Test
//     @DisplayName("DELETE /book/{id} should not fail when book doesn't exist")
//     void testDeleteNonExistingBook() throws Exception {
//         doNothing().when(booksRepository).deleteById(999L);

//         mockMvc.perform(delete("/book/999"))
//                 .andExpect(status().isOk());

//         verify(booksRepository, times(1)).deleteById(999L);
//     }

//     @Test
//     @DisplayName("POST /books should handle invalid JSON")
//     void testCreateBookWithInvalidJson() throws Exception {
//         mockMvc.perform(post("/books")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{invalid json}"))
//                 .andExpect(status().isBadRequest());

//         verify(booksRepository, never()).save(any(Book.class));
//     }

//     @Test
//     @DisplayName("POST /books should handle book with null values")
//     void testCreateBookWithNullValues() throws Exception {
//         Book bookWithNulls = new Book(null, null);
//         Book savedBook = new Book(null, null);
//         savedBook.setId(1L);

//         when(booksRepository.save(any(Book.class))).thenReturn(savedBook);

//         mockMvc.perform(post("/books")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(bookWithNulls)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id", is(1)))
//                 .andExpect(jsonPath("$.title").doesNotExist())
//                 .andExpect(jsonPath("$.author").doesNotExist());

//         verify(booksRepository, times(1)).save(any(Book.class));
//     }
// }