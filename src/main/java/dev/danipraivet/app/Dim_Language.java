package dev.danipraivet.app;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dim_language")
public class Dim_Language {

    @Id
    @Column(name = "LanguageCode", length = 7)
    private String languageCode;

    @Column(name = "Language", length = 30)
    private String language;

    @Column(name = "created_dt")
    private LocalDateTime created_dt;

    @Column(name = "updated_dt")
    private LocalDateTime updated_dt;

    // --- Getters y Setters ---
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getCreated_dt() {
        return created_dt;
    }

    public void setCreated_dt(LocalDateTime created_dt) {
        this.created_dt = created_dt;
    }

    public LocalDateTime getUpdated_dt() {
        return updated_dt;
    }

    public void setUpdated_dt(LocalDateTime updated_dt) {
        this.updated_dt = updated_dt;
    }
}
