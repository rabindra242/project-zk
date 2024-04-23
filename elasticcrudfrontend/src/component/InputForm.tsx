
import { useForm } from "react-hook-form";
import axios from "axios"; // Import Axios for making HTTP requests

function BookForm() {
    const { register, handleSubmit, formState: { errors } } = useForm();

    const onSubmit = async (data) => {
        try {

            // Make POST request to backend endpoint
            await axios.post("http://localhost:8080/api/books/post", data);
            console.log("Data submitted successfully:", data);
        } catch (error) {
            console.error("Error submitting data:", error);
        }
    };

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <input
                {...register("name", { required: true })}
                aria-invalid={errors.name ? "true" : "false"}
                placeholder="Name"
            />
            {errors.name && <p role="alert">Name is required</p>}

            <input
                {...register("age", { required: true })}
                aria-invalid={errors.age ? "true" : "false"}
                placeholder="Age"
                type="number"
            />
            {errors.age && <p role="alert">Age is required</p>}

            <input
                {...register("address", { required: true })}
                aria-invalid={errors.address ? "true" : "false"}
                placeholder="Address"
            />
            {errors.address && <p role="alert">Address is required</p>}

            <input
                {...register("course", { required: true })}
                aria-invalid={errors.course ? "true" : "false"}
                placeholder="Course"
            />
            {errors.course && <p role="alert">Course is required</p>}

            <button type="submit">Submit</button>
        </form>
    );
}

export default BookForm;
