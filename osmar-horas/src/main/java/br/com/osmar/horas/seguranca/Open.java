package br.com.osmar.horas.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*Para dizer para o VRaptor que tal coisa pode ser usado inclusive por usuarios deslogados, e o @Target
é para que possa ser usada apenas em metodos, mas anotação é descartada na compilação então @Retention,
e estou dizeindo que ela vai durar até eu executar o código RUNTIME, pois se deixar o padrão não vou conseguir usar 
em tempo de execução*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Open {
	
}
