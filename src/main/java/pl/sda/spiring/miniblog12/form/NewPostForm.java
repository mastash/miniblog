package pl.sda.spiring.miniblog12.form;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class NewPostForm {
    @NotNull
    @NotBlank
    @Size(min = 5)
    private String title;
    @NotNull
    @NotBlank
    @Size(min = 4)
    private String comment;


//    @NotBlank
//    @Size(min = 5)
//    private String title;
//    @NotBlank
//    @Size(min = 10)
//    private String postBody;

//    @NotNull
//    @NotBlank
//    private String text;

}
