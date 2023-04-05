package vip.marcel.web.firstwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import vip.marcel.web.firstwebapp.entities.Apply;
import vip.marcel.web.firstwebapp.repositories.ApplyRepository;

import java.util.Optional;

@RestController
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    ApplyRepository applyRepository;

    @PostMapping("")
    public void createApply(@RequestBody Apply apply) {
        applyRepository.save(apply);
    }

    @GetMapping("/{id}")
    public Apply readApply(@PathVariable Long id) {
        Optional<Apply> apply = applyRepository.findById(id);

        if(apply.isPresent()) {
            return apply.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application with this id not found.");
    }

    @PutMapping("/{id}")
    public void updateApply(@PathVariable Long id, @RequestBody Apply applyUpdate) {
        Optional<Apply> apply = applyRepository.findById(id);

        if(!apply.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application with this id not found.");
        }

        Apply applyInstance = apply.get();

        applyInstance.setName(applyUpdate.getName());
        applyInstance.setBirthday(applyUpdate.getBirthday());
        applyInstance.setDiscordTag(applyUpdate.getDiscordTag());
        applyInstance.setEmail(applyUpdate.getEmail());
        applyInstance.setText(applyUpdate.getText());

        applyRepository.save(applyInstance);
    }

    @DeleteMapping("/{id}")
    public void deleteApply(@PathVariable Long id) {
        Optional<Apply> apply = applyRepository.findById(id);

        if(apply.isPresent()) {
            applyRepository.deleteById(id);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application with this id not found.");
    }

}
