package ca.javateacher.petsitters.ents;

import ca.javateacher.petsitters.base.ReviewGrade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@SuppressWarnings("ALL")
@Entity
@Table(name="P_REVIEW")
public class Review extends AbstractEntity {

    @ManyToOne
    private Request request;

    @ManyToOne
    private Response response;

    @NotEmpty
    @Enumerated(EnumType.ORDINAL)
    private ReviewGrade grade;

    @Size(max = 500)
    @NotEmpty
    private String details;

    //required by JPA
    public Review() {
        super();
    }

    public ReviewGrade getGrade() {
        return grade;
    }

    public void setGrade(ReviewGrade grade) {
        this.grade = grade;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Review review = (Review) o;

        if (request != null ? !request.equals(review.request) : review.request != null) return false;
        if (response != null ? !response.equals(review.response) : review.response != null) return false;
        return grade == review.grade;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Review[request_id='%,.2f', response_id='%,.2f', grade='%s', details='%s']",
                request.getId(), response.getId(), grade.toString(), details);
    }
}
