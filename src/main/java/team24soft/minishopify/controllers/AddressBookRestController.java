package team24soft.minishopify.controllers;

import org.springframework.web.servlet.view.RedirectView;
import team24soft.minishopify.models.AddressBook;
import team24soft.minishopify.models.BuddyInfo;
import team24soft.minishopify.repositories.AddressBookRepository;
import team24soft.minishopify.repositories.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AddressBookRestController {

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/createBook")
    public AddressBook createBook(@RequestParam(name="id", required = false,defaultValue = "1") long id){

        AddressBook book = new AddressBook(id);

        addressBookRepository.save(book);
        System.out.println("id is: " +book.getId());
        AddressBook book2 = addressBookRepository.findById(id);
        System.out.println("id in repository is: " +book2.getId());
        return book;
    }
    @GetMapping("/addressBook")
    public AddressBook addressBook(){

        AddressBook book = addressBookRepository.findById(1);
        if(addressBookRepository.findById(1) == null)
            System.out.println("nullllllllllllll");
        System.out.println(book.getId());


        //return "redirect:addressBook.html";
        return book;
        //return new RedirectView("addressBook.html");
    }


    @GetMapping("/addBuddy")
    public RedirectView addBuddy(@RequestParam(name="name", required = false,defaultValue = "1") String name,
                                 @RequestParam(name="quantity", required = false,defaultValue = "") String quantity,
                                 @RequestParam(name= "category", required = false,defaultValue = "") String category){


        AddressBook book2 = addressBookRepository.findById(1);
        if(book2 != null)
            System.out.println("heeeere: " +book2.getId());

        AddressBook book;
        if(addressBookRepository.findById(1) == null)
            book = new AddressBook(1);
        else
            book = addressBookRepository.findById(1);

        addressBookRepository.save(book);
        System.out.println("id is: " +book.getId());
        book2 = addressBookRepository.findById(1);
        System.out.println("id in repository is: " +book2.getId());

        BuddyInfo buddy = new BuddyInfo(name,quantity,category);

        book.addBuddy(buddy);

        buddyInfoRepository.save(buddy);
        addressBookRepository.save(book);

        //return "redirect: /index.html";
        return new RedirectView("");

    }

    @GetMapping("/removeBuddy")
    public AddressBook removeBuddy(@RequestParam(name="bookId", required = false,defaultValue = "1") long idBook,
                                   @RequestParam(name="firstName", required = false,defaultValue = "") long idBuddy){

        AddressBook book = addressBookRepository.findById(idBook);

        BuddyInfo buddy = buddyInfoRepository.findById(idBuddy);

        book.removeBuddy(buddy);

        addressBookRepository.save(book);

        return book;
    }

}