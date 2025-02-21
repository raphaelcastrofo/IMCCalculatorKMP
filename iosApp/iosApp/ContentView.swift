import SwiftUI
import shared

struct ContentView: View {

    @state private var weight = ""
    @state private var height = ""
    @state private var result = ""

    var body: some View {
        VStack {
        TextField("Insira seu peso (Kg)", text: $weight)
        .keyboardType(.decimalPad)
        .padding()
        .TextField("Insira sua altura (m)", text: $height)
        .keyboardType(.decimalPad)
        .padding()
        Button("Calcule IMC")
        let weightValue = Double(weight) ?? 0.0
        let heightValue = Double(height) ?? 0.0
        result = calculateIMC(weight: weightValue, height: heightValue)
        }
        .padding()
        Text(result)
        .padding()
    }
    .padding()
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}