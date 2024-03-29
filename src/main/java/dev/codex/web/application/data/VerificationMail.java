package dev.codex.web.application.data;

import java.util.Objects;

public final class VerificationMail implements Mail {
    private final String to;
    private final String subject = "Please Activate your Account";
    private final String text;

    public VerificationMail(String to, String text) {
        this.to = to;
        this.text = text;
    }

    @Override
    public String to() {
        return this.to;
    }

    @Override
    public String subject() {
        return this.subject;
    }

    @Override
    public String text() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VerificationMail that)) return false;
        return Objects.equals(this.to, that.to)
                && Objects.equals(this.text, that.text);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = this.to != null ? this.to.hashCode() : 0;
        result = PRIME * result + this.subject.hashCode();
        result = PRIME * result + (this.text != null ? this.text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NotificationEmail[" +
                "to='" + this.to + "'" +
                ", subject='" + this.subject + "'" +
                ", text='" + this.text + "'" +
                "]";
    }

}