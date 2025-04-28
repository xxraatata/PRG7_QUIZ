package id.co.quiz1_prg7_038.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Ubah menjadi lebih general agar semua endpoint bisa diakses
        registry.addMapping("/**")  // Semua endpoint
                .allowedOrigins("http://localhost:63342")  // Ganti dengan port FE Anda (misal: 5500, 3000)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Menambahkan OPTIONS untuk preflight
                .allowedHeaders("*")
                .allowCredentials(true);  // Jika menggunakan cookies/session
    }
}
